package com.example.pidev_finance.Controllers;

import com.example.pidev_finance.entities.Investment;

import com.example.pidev_finance.services.InvestmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/Investissement")
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
    @PostMapping("/invest")
    public ResponseEntity<Investment> invest(@RequestParam Integer clientId, @RequestParam Integer amount) {
        Investment investment = investmentService.invest(clientId, amount);
        return ResponseEntity.ok().body(investment);
    }
}
