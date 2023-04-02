package com.example.pidev_finance.services;




import com.example.pidev_finance.entities.AccOrRef;
import com.example.pidev_finance.entities.Offers_Credit;
import com.example.pidev_finance.entities.Request;


import com.example.pidev_finance.entities.User;
import com.example.pidev_finance.repositories.IAccOrRefRepository;
import com.example.pidev_finance.repositories.IOffers_CreditRepository;
import com.example.pidev_finance.repositories.IRequestRepository;
import com.example.pidev_finance.repositories.IUserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {
    private IRequestRepository IRequestrepository;
    private  IOffers_CreditRepository iOffersCreditRepository;
    private IUserRepository userRepository;

    private IAccOrRefRepository acc;


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
    public Request assignRequestToOffers_Credit(Integer id_request, Integer id_offer, Integer id_user){
        Request request=IRequestrepository.findById(id_request).orElse(null);
        User user = userRepository.findById(id_user).orElse(null);
        if(user==null){
            throw new IllegalArgumentException("user invalid");
        }
        Offers_Credit offers_credit=iOffersCreditRepository.findById(id_offer).orElse(null);


        request.setUser(user);
        request.setOffer(offers_credit);
        return IRequestrepository.save(request);
    }




    @Override
    public AccOrRef matching(Integer id_request ) {
        List<AccOrRef> all =acc.findAll();

        Request req = IRequestrepository.findById(id_request).orElse(null);
        AccOrRef azz = new AccOrRef();

            if (req.getOffer().getId_offer() != null && req.getUser().getId_user() != null) {
                for (AccOrRef verif:all){
                    if (verif.getRequest().getOffer().getId_offer()==req.getOffer().getId_offer() && verif.getRequest().getUser().getId_user()==req.getUser().getId_user()){
                        return null;

                    }
                }


                if (req.getOffer().getMax_amount() >= req.getAmount_req() && req.getOffer().getMin_amount() <= req.getAmount_req()) {
                    azz.setRequest(req);
                    azz.setCheck_loan("Request accepté");
                    req.setAccOrRef(azz);



                }

                else {
                    azz.setRequest(req);
                    azz.setCheck_loan("Request réfusé");
                    req.setAccOrRef(azz);



                }

            }
        return acc.save(azz);
        }

  @Override
    public List<String> chek_loan(Integer id_user) {
        List<String> All= new ArrayList<>();
        List<Request> list = IRequestrepository.findRequestByUser(id_user);
        for (Request req : list ){
           {
               AccOrRef accOrRef = req.getAccOrRef();
               if (accOrRef.getCheck_loan()!=null){
                   All.add(req.getUser().getUser_firstname()+ " :request numéro: " +accOrRef.getRequest().getId_request() +" : "+  accOrRef.getCheck_loan()+   " :Offer credit numéro: "+ req.getOffer().getId_offer());
               }


            }
        }
      return All;
  }
}























