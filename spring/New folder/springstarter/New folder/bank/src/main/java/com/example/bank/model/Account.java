package com.example.bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account", schema = "training", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "account_number" }) })
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true)
    private String accountNumber; // alwayes need to be unique

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "opened_date")
    private LocalDate openedDate = LocalDate.now(); // add default value

    @Column(name = "currency")
    private Currency currency = Currency.ETB; // ETB,USD

    @Column(name = "account_type")
    private AccountType accountType; // savings, checking

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "overdraft_limit")
    private BigDecimal overdraftLimit;

}
