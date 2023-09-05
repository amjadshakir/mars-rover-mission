package com.techreturners.marsrovermission.model;

public enum Direction {
   N("North"),
   S("South"),
   E("East"),
   W("West");

    private final String value;
    Direction(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
