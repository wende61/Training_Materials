package org.eclipse.jakarta.hello;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double balance;

    public double getBalance() {
        return balance;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
