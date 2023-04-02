package com.example.pidev_finance.controllers;

import com.example.pidev_finance.entities.AccOrRef;
import com.example.pidev_finance.entities.Request;


import com.example.pidev_finance.services.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Request")

public class RequestRestController {
    private RequestService requestService;

    @PostMapping("/add")
    Request addRequest(@RequestBody Request request){
        return requestService.AddRequest(request);
    }
    @GetMapping("/all")
    List<Request> retrieveAllRequests(){

        return requestService.retrieveAllRequests();
    }
    @GetMapping("/get/{id}")
    Request retrieveRequest(@PathVariable("id") Integer IdRequest){
        return requestService.retrieveRequest(IdRequest);
    }
    @DeleteMapping("/delete/{id}")
    void RemoveRequest(@PathVariable("id") Integer IdRequest){
        requestService.removeRequest(IdRequest);
    }
    @PutMapping ("/update")
    Request updateRequest(@RequestBody Request request){
        return requestService.updateRequest(request);
    }

    @GetMapping ("/assignreqtooffers_credit/{id_request}/{id_offer}/{id_user}")
    public Request assignreqtooffers_credit(@PathVariable("id_request") Integer id_request, @PathVariable("id_offer") Integer id_offer,@PathVariable("id_user") Integer id_user){
        return requestService.assignRequestToOffers_Credit(id_request,id_offer,id_user);
    }
    @PostMapping("/mat/{id_request}")
    void matching(@PathVariable("id_request") Integer id_request){
        requestService.matching(id_request);
    }



    @GetMapping("/users/{userId}/loans")
    public ResponseEntity<List<String>> getLoanStatusForUser(@PathVariable Integer userId) {
        List<String> loanStatusList = requestService.chek_loan(userId);
        return ResponseEntity.ok(loanStatusList);
    }






 }


