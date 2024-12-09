package com.example.capstone2.Repository;

import com.example.capstone2.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findTransactionById(Integer id);
    List<Transaction> findTransactionByStatus(Boolean status);
}
