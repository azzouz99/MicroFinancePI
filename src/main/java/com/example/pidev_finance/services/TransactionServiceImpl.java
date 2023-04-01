package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.Investment;
import com.example.pidev_finance.entities.Status_Tr;
import com.example.pidev_finance.entities.Transaction;
import com.example.pidev_finance.entities.User;
import com.example.pidev_finance.repositories.IInvestmentRepository;
import com.example.pidev_finance.repositories.ITransactionRepository;
import com.example.pidev_finance.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private ITransactionRepository ItransactionRepository;
    private IUserRepository  userRepository;
    private IInvestmentRepository iinvestmentRepository;
    @Override
    public List<Transaction> retrieveAllTransactions(){
        return ItransactionRepository.findAll();
    }
    @Override
    public Transaction AddTransaction(Transaction transaction){
        return  ItransactionRepository.save(transaction);
    }
    @Override
   public void removeTransaction(Integer numTransaction){
        ItransactionRepository.deleteById(numTransaction);
   }
   @Override
    public Transaction retrieveTransaction(Integer numTransaction){
        return ItransactionRepository.findById(numTransaction).orElse(null);
    }
    @Override
    public Transaction updateTransaction(Transaction transaction){
        return ItransactionRepository.save(transaction);
    }
    @Override
    public Transaction assignTransactionToInvestment(Integer id_transaction,Integer id_invest){
        Transaction transaction=ItransactionRepository.findById(id_transaction).orElse(null);
        Investment investment = iinvestmentRepository.findById(id_invest).orElse(null);
        transaction.setInvestment(investment);
        return ItransactionRepository.save(transaction);
    }
    @Override
  public Transaction withdraw(Integer userId,Float amount,Integer receiverId){
      User user = userRepository.findById(userId)
              .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
      User receiver = userRepository.findById(receiverId)
              .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
      Float userAmount = user.getAmount();
      Float recAmount=receiver.getAmount();
      if (user.getAmount() < amount) {
          throw new IllegalArgumentException("User does not have enough balance to make the transaction");
      }
      user.setAmount(userAmount - amount);
      userRepository.save(user);
      receiver.setAmount(recAmount + amount);
      userRepository.save(receiver);
      Transaction transaction= new Transaction();
      transaction.setDate_transaction(Calendar.getInstance().getTime());
      transaction.setValue(amount);
      transaction.setSender(userId);
      transaction.setReceiver(receiverId);
      transaction.setUser(user);
return  ItransactionRepository.save(transaction);
  }
}
