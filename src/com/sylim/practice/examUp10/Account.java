package com.sylim.practice.examUp10;

public class Account {
    private String owner;
    private int balance;

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // 1원 ~ 1억까지
    // 1,2, 99999999, 1억
    // 1억 1원
    public void transfer(Account dest, int amount) {
        dest.setBalance(dest.getBalance() + amount);
        balance -= amount;
    }

    @Override
    public String toString() {
        return "[owner " + owner + " balance " + balance;
    }

}
