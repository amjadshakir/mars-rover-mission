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

    }
    public void turnLeft(){
        switch (position.getDirection()){
            case N -> position.setDirection(Direction.W);
            case S -> position.setDirection(Direction.E);
            case E -> position.setDirection(Direction.N);
            case W -> position.setDirection(Direction.S);
        }


    }
    public void turnRight(){
        position.setDirection(Direction.E);

    }
}
