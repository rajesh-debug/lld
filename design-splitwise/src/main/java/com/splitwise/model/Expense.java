package com.splitwise.model;

import java.util.List;

public class Expense {

    private String id;
    private String description;
    private Double amount;
    private User paidBy;
    private List<Split> splitList;

    public Expense(String id, String description, Double amount, User paidBy, List<Split> splitList) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitList = splitList;
    }

    public List<Split> getSplits() {
        return splitList;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
