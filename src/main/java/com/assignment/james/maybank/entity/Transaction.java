package com.assignment.james.maybank.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "trx_data")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "trx_amount", nullable = false)
    private double trxAmount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "trx_date", columnDefinition = "DATE")
    private LocalDate trxDate;

    @Column(name = "trx_time", columnDefinition = "TIME")
    private LocalTime trxTime;

    @Column(name = "customer_id", nullable = false)
    private int customerId;
}