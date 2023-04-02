package com.example.pidev_finance.services;


import com.example.pidev_finance.entities.AccOrRef;
import com.example.pidev_finance.entities.Request;


import java.util.List;

public interface RequestService {
    List<Request> retrieveAllRequests();
    Request AddRequest(Request request);
    void removeRequest(Integer numRequest);
    Request retrieveRequest(Integer numRequest);
    Request updateRequest(Request request);

    Request assignRequestToOffers_Credit(Integer id_request, Integer id_offer,Integer id_user );
    AccOrRef matching (Integer id_request);
    List<String> chek_loan(Integer id_user);















}
