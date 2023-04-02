package com.example.pidev_finance.repositories;

import com.example.pidev_finance.entities.Offers_Credit;
import com.example.pidev_finance.entities.Request;
import com.example.pidev_finance.entities.Type_of_credit;
import com.example.pidev_finance.services.Offers_CreditService;
import com.example.pidev_finance.services.Offers_CreditServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public interface IOffers_CreditRepository extends JpaRepository<Offers_Credit,Integer> {






}
