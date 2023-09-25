package com.techreturners.marsrovermission.service;

import com.techreturners.marsrovermission.model.*;
import com.techreturners.marsrovermission.model.vehicle.Rover;

import java.util.List;

import static com.techreturners.marsrovermission.model.Movable.*;
public class RoverService {
    private Coordinates coordinates;
    private Position position;
    private Rover rover;
    public RoverService(int xCoordinate,int yCoordinate,Direction direction){
        coordinates = new Coordinates(xCoordinate,yCoordinate);
        position = new Position(coordinates, direction);
        rover = new Rover(position);
    }
    public void maneuveringRover(String roverMovementRules, PlateauService plateauService, List<Coordinates> obstacles){
        obstacleLoop:
        for (char c : roverMovementRules.toCharArray()) {
        switch (String.valueOf(c)) {
                case LEFT -> getRover().turnLeft();
                case RIGHT -> getRover().turnRight();
                case MOVE -> {
                    int x = getRover().getPosition().getCoordinates().getXCoordinate();
                    int y = getRover().getPosition().getCoordinates().getYCoordinate();
                    switch (getRover().getPosition().getDirection()) {
                        case N -> {
                            if (y == plateauService.getPlateau().getMaxCoordinates().getYCoordinate()) {
                                System.out.println("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                continue;
                            }
                            for (Coordinates coordinates: obstacles) {
                                if (x==coordinates.getXCoordinate()&&y+1==coordinates.getYCoordinate()){
                                    System.out.println("you are about to hit an obstacle, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                    continue obstacleLoop;
                                }

                            }
                        }
                        case S -> {
                            if (y == 0) {
                                System.out.println("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                continue;
                            }
                            for (Coordinates coordinates: obstacles) {
                                if (x==coordinates.getXCoordinate()&&y-1==coordinates.getYCoordinate()){
                                    System.out.println("you are about to hit an obstacle, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                    continue obstacleLoop;
                                }

                            }
                        }
                        case E -> {
                            if (x == plateauService.getPlateau().getMaxCoordinates().getXCoordinate()) {
                                System.out.println("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                continue;
                            }
                            for (Coordinates coordinates: obstacles) {
                                if (x+1==coordinates.getXCoordinate()&&y==coordinates.getYCoordinate()){
                                    System.out.println("you are about to hit an obstacle, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                    continue obstacleLoop;
                                }

                            }
                        }
                        case W -> {
                            if (x == 0) {
                                System.out.println("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                continue;
                            }
                            for (Coordinates coordinates: obstacles) {
                                if (x-1==coordinates.getXCoordinate()&&y==coordinates.getYCoordinate()){
                                    System.out.println("you are about to hit an obstacle, so the program is gonna skip this movement rule, " + c + " and try to action the next movement rule");
                                    continue obstacleLoop;
                                }

                            }

                        }
                    }
                    getRover().move();
                }
            }
        }
    }
    public Rover getRover() {
        return rover;
    }
    public void displayCurrentRoverPosition() {
        System.out.println(rover.toString());
    }
}
