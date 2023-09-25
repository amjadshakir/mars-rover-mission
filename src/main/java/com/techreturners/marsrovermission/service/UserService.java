package com.techreturners.marsrovermission.service;

import com.techreturners.marsrovermission.model.Coordinates;
import com.techreturners.marsrovermission.model.Direction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.techreturners.marsrovermission.model.Movable.*;

public class UserService {
    private List<Coordinates> obstacles = new ArrayList<>();
    private Scanner scanner;
    public UserService(Scanner scanner){
        this.scanner = scanner;
    }    
    int handleUserInputForCoordinateValueForThePlateau(String coordinate) {
        int coordinateOfPlateau = 0;
        do {
            try {
                System.out.println("Please enter the "+ coordinate + " coordinate (max) for the plateau");
                coordinateOfPlateau = scanner.nextInt();
                while (coordinateOfPlateau < 1) {
                    System.out.println("You have entered a negative number or zero for the "+ coordinate + " coordinate: " + coordinateOfPlateau + ". Please enter a valid integer value.");
                    coordinateOfPlateau = scanner.nextInt();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("You did not enter an int value for the "+ coordinate + " coordinate. Please enter a valid integer value.");
                scanner.next();
            }
        } while (scanner.hasNextLine());
        return coordinateOfPlateau;
    }
    int handleUserInputCoordinateValueForTheRoverPosition(String coordinate, int coordinateOfPlateau) {
        int roverCoordinate = 0;
        do {
            try {
                System.out.println("Please enter the "+ coordinate + " coordinate for the rover position");
                roverCoordinate = scanner.nextInt();
                while (roverCoordinate < 0 || roverCoordinate > coordinateOfPlateau) {
                    System.out.println("You entered a negative number or number greater than plateau size for the " + coordinate + " coordinate, " + roverCoordinate + " of rover position. Please enter a valid integer value.");
                    roverCoordinate = scanner.nextInt();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("You did not enter an int value for the "+ coordinate + " coordinate of rover position. Please enter a valid integer value.");
                scanner.next();
            }
        } while (scanner.hasNextLine());
        return roverCoordinate;
    }
    String handleUserInputDirectionValueForRoverPosition(){
        String orientation;
        do {
            System.out.println("Enter the direction of the rover. eg. N or S or E or W");
            orientation = scanner.next().toUpperCase();
            while (!(orientation.equalsIgnoreCase("N") || orientation.equalsIgnoreCase("S") || orientation.equalsIgnoreCase("E") || orientation.equalsIgnoreCase("W"))) {
                System.out.println("You entered an invalid value for the direction: " + orientation + ". Please enter a valid value. Please note that the direction can be either N or S or E or W.");
                orientation = scanner.next().toUpperCase();
            }
            break;
        } while (scanner.hasNextLine());
        return orientation;
    }
    String handleUserInputForMovementRules(){
        System.out.println("Enter the movement rules on the plateau. Please note you can enter only values L, R or M. eg  LMMRLLM");
        String movement = null;
        while (scanner.hasNextLine()) {
            boolean isMovementRulesInvalid;
            do {
                movement = scanner.next().toUpperCase();
                isMovementRulesInvalid = validateMovementRules(movement);
            } while (isMovementRulesInvalid);
            break;
        }
        return movement;
    }
    private void exitApp(){
        if (scanner.next().equals("exit")) {
            System.exit(0);
        }
    }
    private Scanner getScanner(){
        return scanner;
    }
    private void closeScanner(){
        scanner.close();
    }
    public void handleUserInput(){
        //  do{
        int xCoordinateOfPlateau = handleUserInputForCoordinateValueForThePlateau("x");
        int yCoordinateOfPlateau = handleUserInputForCoordinateValueForThePlateau("y");
        PlateauService plateauService = new PlateauService(xCoordinateOfPlateau, yCoordinateOfPlateau);
        do{
            int roverX = handleUserInputCoordinateValueForTheRoverPosition("x", xCoordinateOfPlateau);
            int roverY = handleUserInputCoordinateValueForTheRoverPosition("y", yCoordinateOfPlateau);
            String orientation = handleUserInputDirectionValueForRoverPosition();
            Direction roverDirection = Direction.valueOf(orientation);
            RoverService roverService = new RoverService(roverX, roverY, roverDirection);
            String movement = handleUserInputForMovementRules();
            roverService.maneuveringRover(movement, plateauService, obstacles);
            System.out.println("The latest rover position is :");
            roverService.displayCurrentRoverPosition();
            System.out.println("You can terminate the application now or continue with another set of data. If you choose to terminate the application, please enter \"exit\", else enter \"continue\"");
            obstacles.add(roverService.getRover().getPosition().getCoordinates());
            exitApp();
        } while(getScanner().hasNextLine());
        closeScanner();
    }
    boolean validateMovementRules(String movementRules){
        boolean isInvalid = false;
        char[] roverRule =   movementRules.toCharArray();
        for (char c: roverRule) {
            String str= String.valueOf(c);
            if (!(str.equals(LEFT)||str.equals(RIGHT)||str.equals(MOVE))){
                isInvalid = true;
                System.out.println("You have entered an invalid value for the rover movement rules. Please enter a valid value Eg: LMLMLLMMM ");
                break;
            }
        }
        return isInvalid;
    }

}
