package com.splitwise.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {

    private final String id;

    private final String name;

    private final Map<String, Double> balances;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.balances = new ConcurrentHashMap<>();
    }

    public Map<String, Double> getBalances() {
        return balances;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
