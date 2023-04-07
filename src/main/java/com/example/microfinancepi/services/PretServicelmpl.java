package com.example.microfinancepi.services;

import com.example.microfinancepi.entities.Pret;
import com.example.microfinancepi.entities.Transaction;
import com.example.microfinancepi.entities.Type_transaction;
import com.example.microfinancepi.entities.User;
import com.example.microfinancepi.repositories.PretRepository;
import com.example.microfinancepi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PretServicelmpl implements PretService {
  private PretRepository pretRepository;
    private TransactionService transactionService;
    private UserRepository userRepository;
    @Override
    public List<Pret> retrieveAllPret(){
        return pretRepository.findAll();
    }

    @Override
    public Pret AddPret(Pret pret){
        return pretRepository.save(pret);
    }
    @Override
    public void RemovePret(Integer pret_id){
        pretRepository.deleteById(pret_id);
    }
    @Override
    public Pret retrievePret(Integer pret_id){
        return pretRepository.findById(pret_id).orElse(null);
    }
    @Override
    public Pret UpdatePret(Pret pret){
        return pretRepository.save(pret);
    }
@Override
    public void pret(Integer userId, Float amount,Integer investmentPeriodInMonths) {
        Transaction transaction = transactionService.withdraw(userId, amount, 1, Type_transaction.PRET);

        Pret pret = new Pret();


        User user = userRepository.findById(userId).orElse(null);
        pret.setId_user(userId);
        pret.setAmount(amount);
        pret.setDate_inv(Calendar.getInstance().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Calendar.getInstance().getTime());
        calendar.add(Calendar.MONTH, investmentPeriodInMonths);
        Date endDate = calendar.getTime();
        pret.setDatefin(endDate);
        pret.setInvestmentPeriodInMonths(investmentPeriodInMonths);

        Float rate = investmentPeriodInMonths == 6 ? 0.020f : 0.05f;
        pret.setInterest(rate * amount);
        pretRepository.save(pret);
    }
@Override
          @Transactional
    @Scheduled(fixedDelay = 86400000)
    public void checkPret() {
    List<Pret> prets = pretRepository.findByDatefinBefore(new Date());
    for (Pret pret : prets) {
    transactionService.withdraw(1,pret.getAmount(), pret.getId_user(),Type_transaction.RETURN);
    transactionService.withdraw(1,pret.getInterest(),pret.getId_user(),Type_transaction.INTEREST);
    }
    }
    }




