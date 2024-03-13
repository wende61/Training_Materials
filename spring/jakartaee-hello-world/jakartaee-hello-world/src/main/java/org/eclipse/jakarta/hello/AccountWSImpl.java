package org.eclipse.jakarta.hello;

import java.util.HashMap;
import java.util.Map;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(endpointInterface = "org.eclipse.jakarta.hello.AccountWS")
public class AccountWSImpl implements AccountWS {

    private final Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountId = 1;

    @Override
    public Account createAccount(@WebParam(name = "name") String name,@WebParam(name = "initialBalance") double initialBalance) {
        Account account = new Account();
        account.setId(nextAccountId++);
        account.setName(name);
        account.setBalance(initialBalance);
        accounts.put(account.getId(), account);
        return account;
    }

    @Override
    public boolean withdraw(@WebParam(name = "accountId") int accountId, @WebParam(name = "amount") double amount) {
        Account account = accounts.get(accountId);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(@WebParam(name = "accountId") int accountId, @WebParam(name = "amount") double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return true;
        }
        return false;
    }

    @Override
    public Account findAccountByName(@WebParam(name = "name") String name) {
        for (Account account : accounts.values()) {
            if (account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }
}
