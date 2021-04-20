package com.assignment.james.maybank.controller;

import com.assignment.james.maybank.assembler.TransactionModelAssembler;
import com.assignment.james.maybank.entity.Transaction;
import com.assignment.james.maybank.exception.TransactionNotFoundException;
import com.assignment.james.maybank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    private final TransactionModelAssembler transactionModelAssembler;

    @Autowired
    private PagedResourcesAssembler<Transaction> pagedResourcesAssembler;

    public TransactionController(TransactionRepository transactionRepository, TransactionModelAssembler transactionModelAssembler) {
        this.transactionRepository = transactionRepository;
        this.transactionModelAssembler = transactionModelAssembler;
    }

    @GetMapping("/transaction")
    public ResponseEntity all(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(pagedResourcesAssembler.toModel(transactions, transactionModelAssembler));
    }

    @GetMapping("/transaction/customerId/{customerId}")
    public ResponseEntity findByCustomerId (Pageable pageable, @PathVariable int customerId) {
        Page<Transaction> transactions = transactionRepository.findByCustomerId(customerId, pageable);
        return ResponseEntity
                .ok()
                .body(pagedResourcesAssembler.toModel(transactions, transactionModelAssembler));
    }

    @GetMapping("/transaction/accountNumber/{accountNumber}")
    public ResponseEntity findByAccountNumber (Pageable pageable, @PathVariable String accountNumber) {
        Page<Transaction> transactions = transactionRepository.findByAccountNumber(accountNumber, pageable);
        return ResponseEntity
                .ok()
                .body(pagedResourcesAssembler.toModel(transactions, transactionModelAssembler));
    }

    @GetMapping("/transaction/description/{description}")
    public ResponseEntity findByDescription (Pageable pageable, @PathVariable String description) {
        Page<Transaction> transactions = transactionRepository.findByDescription(description, pageable);
        return ResponseEntity
                .ok()
                .body(pagedResourcesAssembler.toModel(transactions, transactionModelAssembler));
    }

    @GetMapping("/transaction/{id}")
    public EntityModel<Transaction> one(@PathVariable Long id) {

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("transaction with id "+  id + "not found"));

        return transactionModelAssembler.toModel(transaction);
    }
}
