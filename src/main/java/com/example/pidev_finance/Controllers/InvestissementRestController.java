package com.example.pidev_finance.Controllers;

import com.example.pidev_finance.entities.Investment;

import com.example.pidev_finance.services.InvestmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/Investment")
public class InvestissementRestController {
    private InvestmentService investmentService;

    @PostMapping("/add")
    Investment AddInvestissement(@RequestBody Investment investment){
        return investmentService.AddInvestissement(investment);
    }
    @GetMapping("/all")
    List<Investment> retrieveAllInvestissements(){

        return investmentService.retrieveAllInvestissements();
    }
    @GetMapping("/get/{id}")
    Investment retrieveInvestissement(@PathVariable("id") Integer numInvestissement){
        return investmentService.retrieveInvestissement(numInvestissement);
    }
    @DeleteMapping("/delete/{id}")
    void RemoveInvestissement(@PathVariable("id") Integer numInvestissement){
        investmentService.RemoveInvestissement(numInvestissement);
    }
    @PutMapping ("/update")
    Investment UpdateInvestissement(@RequestBody Investment investment){
        return investmentService.UpdateInvestissement(investment);
    }
    @PostMapping("/users/{userId}/invest")
    public void pret(@PathVariable Integer userId, @RequestParam("amount") Float amount,@RequestParam("period") Integer period) {
        investmentService.pret(userId, amount, period);
    }
 @PostMapping("/check")
    public void checkInvestments() {
        investmentService.checkInvestments();
    }
}
