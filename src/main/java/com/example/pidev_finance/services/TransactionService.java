package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.Transaction;

import java.util.List;

public interface  TransactionService {
    List<Transaction> retrieveAllTransactions();
    Transaction AddTransaction(Transaction transaction);
    void removeTransaction(Integer numTransaction);
    Transaction retrieveTransaction(Integer numTransaction);
    Transaction updateTransaction(Transaction transaction);
    Transaction assignTransactionToInvestment(Integer id_transaction,Integer id_invest);
    Transaction withdraw(Integer userId,Float amount,Integer receiverId);



}
