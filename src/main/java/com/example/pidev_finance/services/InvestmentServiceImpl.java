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
    public Investment invest(Integer clientId, Integer amount) {
        Investment investment = new Investment();
        investment.setId_client(clientId);
        investment.setAmount_inv(amount);
        investment.setDate_inv(new Date());

        // Add 10% return on investment
        double returnAmount = amount * 0.1;
        int totalAmount = (int) Math.round(amount + returnAmount);
        investment.setAmount_inv(totalAmount);

        return iinvestmentRepository.save(investment);}
}
