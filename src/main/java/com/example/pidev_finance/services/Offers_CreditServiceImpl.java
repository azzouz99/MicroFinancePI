package com.example.pidev_finance.services;
import com.example.pidev_finance.entities.Offers_Credit;
import com.example.pidev_finance.entities.Request;
import com.example.pidev_finance.repositories.IOffers_CreditRepository;

import com.example.pidev_finance.repositories.IRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class Offers_CreditServiceImpl implements Offers_CreditService{
    @Autowired
    private IOffers_CreditRepository Ioffers_creditrepository;
    @Autowired
    private IRequestRepository IRequestRepository;



    @Override
    public List<Offers_Credit> retrieveAllOffers_Credits() {
        return Ioffers_creditrepository.findAll();
    }

    @Override
    public Offers_Credit AddOffers_Credit(Offers_Credit offers_credit) {
        return Ioffers_creditrepository.save(offers_credit);
    }

    @Override
    public void removeOffers_Credit(Integer numOffers_Credit) {
        Ioffers_creditrepository.deleteById(numOffers_Credit);
    }

    @Override
    public Offers_Credit retrieveOffers_Credit(Integer id_offer) {
        return Ioffers_creditrepository.findById(id_offer).orElse(null);
    }

    @Override
    public Offers_Credit updateOffers_Credit(Offers_Credit offers_credit) {
        return Ioffers_creditrepository.save(offers_credit);
    }

    @Override
    public Map<Integer, Map<String, Double>> calculateCapitalAmortiAndRestant(Integer id_offer, Integer id_request) {
        Offers_Credit offreCredit = Ioffers_creditrepository.findById(id_offer).orElse(null);
        Request request = IRequestRepository.findById(id_request).orElse(null);
        if (offreCredit == null || request == null) {
            throw new IllegalArgumentException("Invalid offre-credit or request id");
        }

        Map<Integer, Map<String, Double>> result = new LinkedHashMap<>();
        double capitalRestant = request.getAmount_req();
        double annuity = calculateAnnuity(request.getAmount_req(), offreCredit.getInterest_rate(), request.getTerm_loan());
        double term_loan = request.getTerm_loan();
        double interest_rate= Double.parseDouble(offreCredit.getInterest_rate());
        double amount_req= request.getAmount_req();




        for (int year = 1; year <= request.getTerm_loan(); year++) {
            Map<String, Double> yearData = new LinkedHashMap<>();
            double capitalAmorti = calculateCapitalAmorti(capitalRestant, annuity, offreCredit.getInterest_rate());
            capitalRestant -= capitalAmorti;
            yearData.put("capitalAmorti", capitalAmorti);
            yearData.put("capitalRestant", capitalRestant);
            yearData.put("term_loan", term_loan);
            yearData.put("interest_rate",interest_rate);
            yearData.put("amount_req",amount_req);

            result.put(year, yearData);
        }


        return result;
    }




    private double calculateAnnuity(double amount, String interestRate, int term) {
        double rate = Double.parseDouble(interestRate.replace("%", "")) / 100.0;
        double r = rate / 12.0;
        double n = term * 12.0;
        return (amount * r) / (1 - Math.pow(1 + r, -n));
    }

    private double calculateCapitalAmorti(double capitalRestant, double annuity, String interestRate) {
        double rate = Double.parseDouble(interestRate.replace("%", "")) / 100.0;
        double r = rate / 12.0;
        return annuity - (capitalRestant * r);

    }
    @Override
    public List<Offers_Credit> findMatchingOffer(Integer amount, String repaymentPeriode) {
        // Récupérer toutes les offres de crédit
        List<Offers_Credit> all = Ioffers_creditrepository.findAll();

        List<Offers_Credit> matchingOffers = new ArrayList<>();

        // Parcourir chaque offre de crédit
        for (Offers_Credit offer : all){
            if(amount >= offer.getMin_amount() && amount <= offer.getMax_amount()){
                if (repaymentPeriode.equals(offer.getRepayment_period())){
                    matchingOffers.add(offer);
                }
            }
        }

        return matchingOffers;
    }














}




