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

    public void maneuveringRover(String roverMovementRules){

        for (Character c : roverMovementRules.toCharArray()) {
            if (c == RoverMovement.LEFT.getValue().charAt(0)) {
                getRover().turnLeft();
            }
            if (c == RoverMovement.RIGHT.getValue().charAt(0)) {
                getRover().turnRight();
            }
            if (c == RoverMovement.MOVE.getValue().charAt(0)) {
                getRover().move();
            }
        }
    }
    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
