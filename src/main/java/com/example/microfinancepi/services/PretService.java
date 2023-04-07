package com.example.microfinancepi.services;

import com.example.microfinancepi.entities.Pret;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.util.List;

public interface PretService {
    List<Pret> retrieveAllPret();

    Pret AddPret(Pret pret);

    void RemovePret(Integer pret_id);

    Pret retrievePret(Integer pret_id);

    Pret UpdatePret(Pret pret);

    void pret(Integer userId, Float amount, Integer investmentPeriodInMonths);

    @Transactional
        @Scheduled(fixedDelay = 86400000)
    void checkPret();
}
