package com.techreturners.marsrovermission.model;

public class Rover extends Vehicle implements Movable{
    private Position position;
    private Plateau plateau;
    public Rover(Position position, Plateau plateau){
        this.position = position;
        this.plateau = plateau;
    }
    public Position getPosition() {
        return position;
    }

    public Plateau getPlateau() {
        return plateau;
    }
    public void move(){
        switch (position.getDirection()) {
            case N -> position.getCoordinates().setYCoordinate(position.getCoordinates().getYCoordinate() + 1);
            case E -> position.getCoordinates().setXCoordinate(position.getCoordinates().getXCoordinate() + 1);
            case W -> position.getCoordinates().setXCoordinate(position.getCoordinates().getXCoordinate() - 1);
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
}
