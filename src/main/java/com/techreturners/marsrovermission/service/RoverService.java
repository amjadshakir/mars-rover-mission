package com.techreturners.marsrovermission.service;

import com.techreturners.marsrovermission.model.*;

public class RoverService {

    private Coordinates coordinates;
    private Position position;
    private Rover rover;

    public RoverService(int xCoordinate,int yCoordinate,Direction direction){
        coordinates = new Coordinates(xCoordinate,yCoordinate);
        position = new Position(coordinates, direction);
        rover = new Rover(position);
    }


    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
