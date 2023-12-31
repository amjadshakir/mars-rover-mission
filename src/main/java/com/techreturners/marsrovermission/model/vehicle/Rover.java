package com.techreturners.marsrovermission.model.vehicle;

import com.techreturners.marsrovermission.model.Direction;
import com.techreturners.marsrovermission.model.Movable;
import com.techreturners.marsrovermission.model.Position;

public class Rover extends Vehicle implements Movable {
    private Position position;
    public Rover(Position position){
        this.position = position;

    }
    public Position getPosition() {
        return position;
    }


    public void move(){
        switch (position.getDirection()) {
            case N -> position.getCoordinates().setYCoordinate(position.getCoordinates().getYCoordinate() + 1);
            case E -> position.getCoordinates().setXCoordinate(position.getCoordinates().getXCoordinate() + 1);
            case W -> position.getCoordinates().setXCoordinate(position.getCoordinates().getXCoordinate() - 1);
            case S -> position.getCoordinates().setYCoordinate(position.getCoordinates().getYCoordinate() - 1);
        }
    }
    public void turnLeft(){
        switch (position.getDirection()){
            case N -> position.setDirection(Direction.W);
            case S -> position.setDirection(Direction.E);
            case E -> position.setDirection(Direction.N);
            case W -> position.setDirection(Direction.S);
            default -> System.out.println("Please enter a valid input");
        }


    }
    public void turnRight(){
        switch (position.getDirection()){
            case N -> position.setDirection(Direction.E);
            case S -> position.setDirection(Direction.W);
            case E -> position.setDirection(Direction.S);
            case W -> position.setDirection(Direction.N);
            default -> System.out.println("Please enter a valid input");
        }


    }
    public String toString(){
        return getPosition().getCoordinates().getXCoordinate() + " "  + getPosition().getCoordinates().getYCoordinate() + " " + getPosition().getDirection().toString();
    }
}
