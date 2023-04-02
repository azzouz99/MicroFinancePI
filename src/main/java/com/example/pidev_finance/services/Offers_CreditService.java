package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.AccOrRef;
import com.example.pidev_finance.entities.OfferStatistics;
import com.example.pidev_finance.entities.Offers_Credit;
import com.example.pidev_finance.entities.Request;


import java.util.List;
import java.util.Map;

public interface Offers_CreditService {
    List<Offers_Credit> retrieveAllOffers_Credits();
    Offers_Credit AddOffers_Credit(Offers_Credit offers_credit);
    void removeOffers_Credit(Integer numOffers_Credit);
    Offers_Credit retrieveOffers_Credit(Integer id_offer);
    Offers_Credit updateOffers_Credit(Offers_Credit offers_credit);
      //List<Double> calculateAmortization (Integer id_offer);
      Map<Integer, Map<String, Double>> calculateCapitalAmortiAndRestant(Integer id_offer, Integer id_request);
      List<Offers_Credit> findMatchingOffer(Integer amount, String repaymentPeriode);
    OfferStatistics getOfferStatistics(Integer id_offer);


}
