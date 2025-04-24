package com.splitwise.model.split;

import com.splitwise.model.Split;
import com.splitwise.model.User;

public class EqualSplit extends Split {

    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}