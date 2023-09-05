package com.techreturners.marsrovermission.model;

public enum RoverMovement {
    LEFT("L"), RIGHT("R"), Move("M");

    private final String position;
    RoverMovement(String position){
        this.position = position;
    }
    public String getPosition(){
        return position;
    }
}
