package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.Investment;

import java.util.List;

public interface InvestmentService {
    List<Investment> retrieveAllInvestissements();
    Investment AddInvestissement(Investment investment);
    void RemoveInvestissement(Integer numInvestissement);
    Investment retrieveInvestissement(Integer numInvestissement);
    Investment UpdateInvestissement(Investment investment);
    void pret(Integer clientId, Float amount,Integer investmentPeriodInMonths) ;
   void checkInvestments();
}

