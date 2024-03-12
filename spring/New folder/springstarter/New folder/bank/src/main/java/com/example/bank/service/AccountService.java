package com.example.bank.service;

import java.util.List;
import java.util.Optional;

import com.example.bank.model.Account;

public interface AccountService {
    public List<Account> getAccounts();
    public Optional<Account> getAccount(Long id);
    public Account createAccount(Account account);
    public Account updateAccount(Long id, Account account);
    public void deleteAccount(Long id);
}
