package com.techreturners.marsrovermission.app;

import com.techreturners.marsrovermission.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverMissionAppTest {
    @Test
    public void checkRoverDirectionWhenTurnLeftFromNorth(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(5,5);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(2,3);
        Position position = new Position(roverCoordinates, Direction.N);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnLeft();
        //assert
        assertEquals(Direction.W,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverDirectionWhenTurnLeftFromSouth(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(7,5);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(3,5);
        Position position = new Position(roverCoordinates,Direction.S);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnLeft();
        //assert
        assertEquals(Direction.E,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverDirectionWhenTurnLeftFromEast(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(8,9);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(4,5);
        Position position = new Position(roverCoordinates,Direction.E);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnLeft();
        //assert
        assertEquals(Direction.N,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverDirectionWhenTurnLeftFromWest(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(5,6);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(4,5);
        Position position = new Position(roverCoordinates,Direction.W);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnLeft();
        //assert
        assertEquals(Direction.S,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverDirectionWhenTurnRightFromNorth(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(5,6);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(4,5);
        Position position = new Position(roverCoordinates,Direction.N);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnRight();
        //assert
        assertEquals(Direction.E,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverDirectionWhenTurnRightFromSouth(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(5,6);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(4,5);
        Position position = new Position(roverCoordinates,Direction.S);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnRight();
        //assert
        assertEquals(Direction.W,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverDirectionWhenTurnRightFromEast(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(5,6);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(4,5);
        Position position = new Position(roverCoordinates,Direction.E);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnRight();
        //assert
        assertEquals(Direction.S,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverDirectionWhenTurnRightFromWest(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(5,6);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(4,5);
        Position position = new Position(roverCoordinates,Direction.W);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnRight();
        //assert
        assertEquals(Direction.N,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverCoordinatesWhenMoveForward(){
        //arrange
        Coordinates maxCoordinates = new Coordinates(5,5);
        Plateau plateau = new Plateau(maxCoordinates);
        Coordinates roverCoordinates = new Coordinates(1,0);
        Position position = new Position(roverCoordinates,Direction.N);
        Rover rover = new Rover(position,plateau);
        //act
        rover.move();
        //assert
        assertEquals(1,rover.getPosition().getCoordinates().getXCoordinate());
        assertEquals(1,rover.getPosition().getCoordinates().getYCoordinate());
    }

}
