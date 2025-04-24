package com.splitwise.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {

    private final String id;

    private final String name;

    private final List<User> users;

    private final List<Expense> expenses;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.users = new CopyOnWriteArrayList<>();
        this.expenses = new CopyOnWriteArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
