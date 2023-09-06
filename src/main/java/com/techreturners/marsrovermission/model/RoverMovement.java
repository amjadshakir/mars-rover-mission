package com.techreturners.marsrovermission.model;

public enum RoverMovement {
    LEFT("L"), RIGHT("R"), MOVE("M");

    private final String value;
    RoverMovement(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
