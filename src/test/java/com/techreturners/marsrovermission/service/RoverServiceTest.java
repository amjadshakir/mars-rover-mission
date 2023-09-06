package com.techreturners.marsrovermission.service;

import com.techreturners.marsrovermission.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverServiceTest {

    @Test
    public void checkXCoordinatesForRoverService(){
        RoverService roverService = new RoverService(5,5, Direction.N);
        assertEquals(5,roverService.getRover().getPosition().getCoordinates().getXCoordinate());
    }
    @Test
    public void checkYCoordinatesForRoverService(){
        RoverService roverService = new RoverService(5,5, Direction.N);
        assertEquals(5,roverService.getRover().getPosition().getCoordinates().getYCoordinate());
    }
    @Test
    public void checkDirectionForRoverService(){
        RoverService roverService = new RoverService(5,5, Direction.N);
        assertEquals(Direction.N,roverService.getRover().getPosition().getDirection());
    }


}
