package com.splitwise.model.split;

import com.splitwise.model.Split;
import com.splitwise.model.User;

public class ExactSplit extends Split {
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}