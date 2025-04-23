package com.rule_engine.model;


public class Outcome {

    private final String header;
    private final String description;
    private final String displayType;

    public Outcome(String header, String description, String displayType) {
        this.header = header;
        this.description = description;
        this.displayType = displayType;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplayType() {
        return displayType;
    }
}
