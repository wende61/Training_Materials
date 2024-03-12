package com.example.bank.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.Account;
import com.example.bank.model.Currency;
import com.example.bank.service.AccountService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AccountController {
    
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAcccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Optional<Account> getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
    
    @PostMapping("/accounts")
    public Account create(@RequestBody Account entity) {
        if(entity.getCurrency() == null)
            entity.setCurrency(Currency.ETB);
        if(entity.getOpenedDate() == null)
            entity.setOpenedDate(LocalDate.now());
        return accountService.createAccount(entity);
    }
    
    @PutMapping("/accounts/{id}")
    public Account update(@RequestBody Account entity, @PathVariable Long id) {
        return accountService.updateAccount(id, entity);
    }

    @DeleteMapping("/accounts/{id}")
    public String delete(@RequestParam Long id) {
        accountService.deleteAccount(id);
        return new String("Successfully deleted account");
    }
    
}
