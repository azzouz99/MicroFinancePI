package com.example.pidev_finance.services;




import com.example.pidev_finance.entities.Offers_Credit;
import com.example.pidev_finance.entities.Request;


import com.example.pidev_finance.repositories.IOffers_CreditRepository;
import com.example.pidev_finance.repositories.IRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {
    private IRequestRepository IRequestrepository;
    private  IOffers_CreditRepository iOffersCreditRepository;
    @Override
    public List<Request>retrieveAllRequests() {
        return IRequestrepository.findAll();
    }

    @Override
    public Request AddRequest(Request request) {
        return IRequestrepository.save(request);
    }

    @Override
    public void removeRequest(Integer numRequest) {
        IRequestrepository.deleteById(numRequest);
    }

    @Override
    public Request retrieveRequest(Integer numRequest) {
        return IRequestrepository.findById(numRequest).orElse(null);
    }

    @Override
    public Request updateRequest(Request request) {
        return IRequestrepository.save(request);
    }

    @Override
    public Request assignRequestToOffers_Credit(Integer id_request, Integer id_offer){
        Request request=IRequestrepository.findById(id_request).orElse(null);
        Offers_Credit offers_credit=iOffersCreditRepository.findById(id_offer).orElse(null);
        request.setOffers_credit(offers_credit);
        return IRequestrepository.save(request);
    }

}


