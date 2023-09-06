package com.techreturners.marsrovermission.app;

import com.techreturners.marsrovermission.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
   private Coordinates maxCoordinates;
   private Plateau plateau;
   private Coordinates roverCoordinates;
    @BeforeEach
    public void setUp(){
        maxCoordinates = new Coordinates(5,6);
        plateau = new Plateau(maxCoordinates);
        roverCoordinates = new Coordinates(1,0);
    }
    @Test
    public void checkRoverDirectionWhenTurnLeftFromNorth(){
        //arrange
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
        Position position = new Position(roverCoordinates,Direction.W);
        Rover rover = new Rover(position,plateau);
        //act
        rover.turnRight();
        //assert
        assertEquals(Direction.N,rover.getPosition().getDirection());
    }
    @Test
    public void checkRoverCoordinatesWhenMoveNorthward(){
        //arrange
        Position position = new Position(roverCoordinates,Direction.N);
        Rover rover = new Rover(position,plateau);
        //act
        rover.move();
        //assert
        assertEquals(1,rover.getPosition().getCoordinates().getXCoordinate());
        assertEquals(1,rover.getPosition().getCoordinates().getYCoordinate());
    }
    @Test
    public void checkRoverCoordinatesWhenMoveEastward(){
        //arrange
        Position position = new Position(roverCoordinates,Direction.E);
        Rover rover = new Rover(position,plateau);
        //act
        rover.move();
        //assert
        assertEquals(2,rover.getPosition().getCoordinates().getXCoordinate());
        assertEquals(0,rover.getPosition().getCoordinates().getYCoordinate());
    }
    @Test
    public void checkRoverCoordinatesWhenMoveWestward(){
        //arrange
        Position position = new Position(roverCoordinates,Direction.W);
        Rover rover = new Rover(position,plateau);
        //act
        rover.move();
        //assert
        assertEquals(0,rover.getPosition().getCoordinates().getXCoordinate());
        assertEquals(0,rover.getPosition().getCoordinates().getYCoordinate());
    }
    @Test
    public void checkRoverCoordinatesWhenMoveSouthward(){
        //arrange
        Position position = new Position(roverCoordinates,Direction.S);
        Rover rover = new Rover(position,plateau);
        //act
        rover.move();
        //assert
        assertEquals(1,rover.getPosition().getCoordinates().getXCoordinate());
        assertEquals(-1,rover.getPosition().getCoordinates().getYCoordinate());
    }

}
