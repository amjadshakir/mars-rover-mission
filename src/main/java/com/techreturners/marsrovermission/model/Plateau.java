package com.techreturners.marsrovermission.model;
public class Plateau {
    private Coordinates maxCoordinates;
    public Plateau (Coordinates maxCoordinates){
       this.maxCoordinates  = maxCoordinates;
    }
    public Coordinates getMaxCoordinates() {
        return maxCoordinates;
    }

}
