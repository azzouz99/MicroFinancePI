package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.Investment;
import com.example.pidev_finance.entities.Transaction;
import com.example.pidev_finance.entities.Type_transaction;

import java.util.List;

public interface  TransactionService {
    List<Transaction> retrieveAllTransactions();
    Transaction AddTransaction(Transaction transaction);
    void removeTransaction(Integer numTransaction);
    Transaction retrieveTransaction(Integer numTransaction);
    Transaction updateTransaction(Transaction transaction);
    Transaction assignTransactionToInvestment(Integer id_transaction,Integer id_invest);

    void assignTransactionToUser(Integer id_transaction, Integer id_user);

    Transaction withdraw(Integer userId, Float amount, Integer receiverId, Type_transaction type);


    Type_transaction testtr(Integer transactionId);

    List<Transaction> findByType(Type_transaction type);

    List<Transaction> findByInvestment(Investment investment);
}
