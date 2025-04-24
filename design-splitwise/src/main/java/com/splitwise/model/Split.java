package com.splitwise.model;

public abstract class Split {
    protected final User user;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    protected double amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }
}