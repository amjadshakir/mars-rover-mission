package com.techreturners.marsrovermission.model;
public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public int getXCoordinate() {
        return xCoordinate;
    }
    public int getYCoordinate() {
        return yCoordinate;
    }
    public void setXCoordinate(int xCoordinate){
        this.xCoordinate = xCoordinate;
    }
    public void setYCoordinate(int yCoordinate){
        this.yCoordinate = yCoordinate;
    }

}
