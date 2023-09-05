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
}
