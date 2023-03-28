package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.Investment;
import com.example.pidev_finance.entities.Transaction;
import com.example.pidev_finance.entities.User;
import com.example.pidev_finance.repositories.IInvestmentRepository;
import com.example.pidev_finance.repositories.ITransactionRepository;
import com.example.pidev_finance.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class InvestmentServiceImpl implements InvestmentService {
    private IInvestmentRepository iinvestmentRepository;
    private ITransactionRepository iTransactionRepository;
    private IUserRepository userRepository;
    private TransactionService transactionService;

    @Override
    public List<Investment> retrieveAllInvestissements(){
        return iinvestmentRepository.findAll();
    }
    @Override
    public Investment AddInvestissement(Investment investment){
        return iinvestmentRepository.save(investment);
    }
    @Override
    public void RemoveInvestissement(Integer numInvestissement){
        iinvestmentRepository.deleteById(numInvestissement);
    }
    @Override
    public Investment retrieveInvestissement(Integer numInvestissement){
        return iinvestmentRepository.findById(numInvestissement).orElse(null);
    }
    @Override
    public Investment UpdateInvestissement(Investment investment){
        return iinvestmentRepository.save(investment);
    }

    @Override
    public void pret(Integer userId, Float amount,Integer investmentPeriodInMonths) {
        transactionService.withdraw(userId,amount,1);
        Investment investment = new Investment();
        investment.setId_client(userId);
        investment.setAmount_inv(amount);
        investment.setDate_inv(Calendar.getInstance().getTime());
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(Calendar.getInstance().getTime());
    calendar.add(Calendar.MONTH, investmentPeriodInMonths);
    Date endDate= calendar.getTime();
        investment.setDatefin(endDate);
        Float rate = investmentPeriodInMonths == 6 ? 0.035f : 0.1f;
        investment.setWin(rate*amount);
        iinvestmentRepository.save(investment);
    }

    @Transactional
    @Scheduled(fixedDelay = 86400000)
    public void checkInvestments() {
    List<Investment> investments = iinvestmentRepository.findByDatefinBefore(new Date());
    for (Investment investment : investments) {
    transactionService.withdraw(1,investment.getAmount_inv()+investment.getWin() , investment.getId_client());
    }
    }



}
