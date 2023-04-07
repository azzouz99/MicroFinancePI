package com.example.microfinancepi.Controllers;

import com.example.microfinancepi.entities.Pret;
import com.example.microfinancepi.services.PretService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pret")
public class PretController {

        private PretService pretService;

        @GetMapping("/qll")
        public List<Pret> getAllPrets() {
            return pretService.retrieveAllPret();
        }

        @GetMapping("get/{pretId}")
        public Pret getPret(@PathVariable("pretId") Integer pretId) {
            return pretService.retrievePret(pretId);
        }

        @PostMapping("/add")
        public Pret addPret(@RequestBody Pret pret) {
            return pretService.AddPret(pret);
        }

        @PutMapping("/update")
        public Pret updatePret(@RequestBody Pret pret) {
            return pretService.UpdatePret(pret);
        }

        @DeleteMapping("/delete/{pretId}")
        public void deletePret(@PathVariable("pretId") Integer pretId) {
            pretService.RemovePret(pretId);
        }
    @PostMapping("/users/{userId}/pret")
    public void pret(@PathVariable Integer userId, @RequestParam("amount") Float amount,@RequestParam("period") Integer period) {
        pretService.pret(userId, amount, period);
    }
    @PostMapping("/check")
    public void checkPret() {
        pretService.checkPret();
    }
    }

