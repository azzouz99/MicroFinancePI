package com.example.pidev_finance.services;


import com.example.pidev_finance.entities.Offers_Credit;
import com.example.pidev_finance.entities.Request;
import com.example.pidev_finance.entities.User;



import java.util.List;

public interface RequestService {
    List<Request> retrieveAllRequests();
    Request AddRequest(Request request);
    void removeRequest(Integer numRequest);
    Request retrieveRequest(Integer numRequest);
    Request updateRequest(Request request);

    Request assignRequestToOffers_Credit(Integer id_request, Integer id_offer,Integer id_user );



}
