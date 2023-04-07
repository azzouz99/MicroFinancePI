package com.example.pidev_finance.repositories;

import com.example.pidev_finance.entities.Investment;
import com.example.pidev_finance.entities.Transaction;
import com.example.pidev_finance.entities.Type_transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findByType(Type_transaction type);
    List<Transaction> findByInvestment(Investment investment);
}
