package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.Investment;
import com.example.pidev_finance.repositories.IInvestmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class InvestmentServiceImpl implements InvestmentService {
    private IInvestmentRepository iinvestmentRepository;


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
    public Investment pret(Integer clientId, Integer amount) {
        Investment investment = new Investment();
        investment.setId_client(clientId);
        investment.setAmount_inv(amount);
        investment.setDate_inv(new Date());

        // Add 10% return on investment
        double returnAmount = amount * 0.1;
        int totalAmount = (int) Math.round(amount + returnAmount);
        investment.setAmount_inv(totalAmount);

        return iinvestmentRepository.save(investment);}
   /**
    public void invest(Integer userId, Float amount) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Float userAmount = user.getAmount();
        if (userAmount < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        user.setAmount(userAmount - amount);
        userRepository.save(user);

        Investment investment = new Investment();
        investment.setIdClient(userId);
        investment.setAmountInv(amount);
        Date investDate = new Date();
        investment.setDateInv(investDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(investDate);
        cal.add(Calendar.YEAR, 1);
        Date endDate = cal.getTime();
        investment.setDateFin(endDate);
        investmentRepository.save(investment);
    }
    @Transactional
    @Scheduled(fixedDelay = 86400000)
    public void checkInvestments() {
    List<Investment> investments = investmentRepository.findByDateFinBeforeAndWithdrawnFalse(new Date());
    for (Investment investment : investments) {
    withdraw(investment.getIdInvest());
    }
    }
    public void withdraw(Integer investmentId) {
    Investment investment = investmentRepository.findById(investmentId)
    .orElseThrow(() -> new IllegalArgumentException("Investment not found"));
    User user = userRepository.findById(investment.getIdClient())
    .orElseThrow(() -> new IllegalArgumentException("User not found"));
    Float investedAmount = investment.getAmountInv();
    Float finalAmount = investedAmount * 1.1f;
    user.setAmount(user.getAmount() + finalAmount);
    userRepository.save(user);
    investmentRepository.delete(investment);
    }
    **/
}
