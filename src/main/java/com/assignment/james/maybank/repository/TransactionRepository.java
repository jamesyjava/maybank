package com.assignment.james.maybank.repository;

import com.assignment.james.maybank.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

    Page<Transaction> findByCustomerId(int customerId, Pageable pageable);

    Page<Transaction> findByAccountNumber(String accountNumber, Pageable pageable);

    Page<Transaction> findByDescription(String description, Pageable pageable);
}