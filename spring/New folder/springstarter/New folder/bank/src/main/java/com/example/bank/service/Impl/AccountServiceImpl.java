package com.example.bank.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account account) {
            Account existingAccount = accountRepository.findById(id).orElse(null);
            if(existingAccount == null) {
                // account to create or respond to user not updated
                return account;
            }
            existingAccount.setAccountHolderName(account.getAccountHolderName());
            existingAccount.setAccountType(account.getAccountType());
            existingAccount.setCurrency(account.getCurrency());
            existingAccount.setBalance(account.getBalance());
            existingAccount.setInterestRate(account.getInterestRate());
            existingAccount.setOverdraftLimit(account.getOverdraftLimit());
            return accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account existingAccount = accountRepository.findById(id).orElse(null);
        if(existingAccount != null) {
            accountRepository.delete(existingAccount);
        }
    }
    
}
