package com.techreturners.marsrovermission.app;

import com.techreturners.marsrovermission.model.Direction;
import com.techreturners.marsrovermission.model.Position;
import com.techreturners.marsrovermission.model.Rover;
import com.techreturners.marsrovermission.model.RoverMovement;
import com.techreturners.marsrovermission.service.PlateauService;
import com.techreturners.marsrovermission.service.RoverService;

import java.util.Scanner;

public class MarsRoverMissionApp {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Plateau Coordinates example: 5 and 5");
        int xCoordinateOfPlateau = input.nextInt();
        int yCoordinateOfPlateau = input.nextInt();
        PlateauService plateauService = new PlateauService(xCoordinateOfPlateau,yCoordinateOfPlateau);
        System.out.println("Please enter Rover Position example: 1 and 1");
        int xCoordinateOfRover = input.nextInt();
        int yCoordinateOfRover = input.nextInt();
        System.out.println("Please enter Rover Direction example: N or S or E or W ");
        String directionOfRover = input.next();
        System.out.println("Please enter your Rover Movement example: LMLMLLMMM");
        RoverService roverService = new RoverService(xCoordinateOfRover,yCoordinateOfRover, Direction.valueOf(directionOfRover));
        String roverMovementRules = input.next();
        System.out.println("Your New Rover Position is " + roverMovementRules);

        for (Character c : roverMovementRules.toCharArray()) {
            if (c == RoverMovement.LEFT.getValue().charAt(0)) {
            roverService.getRover().turnLeft();
            }
            if (c == RoverMovement.RIGHT.getValue().charAt(0)) {
                roverService.getRover().turnRight();
            }
            if (c == RoverMovement.MOVE.getValue().charAt(0)) {
                roverService.getRover().move();
            }
        }
            System.out.println(roverService.getRover().getPosition().getCoordinates().getXCoordinate() + " " + roverService.getRover().getPosition().getCoordinates().getYCoordinate() + " " + roverService.getRover().getPosition().getDirection());
    }
}


