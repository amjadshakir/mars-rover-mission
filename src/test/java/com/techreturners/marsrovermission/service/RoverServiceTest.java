package com.techreturners.marsrovermission.service;

import com.techreturners.marsrovermission.model.Coordinates;
import com.techreturners.marsrovermission.model.Direction;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void checkManeuveringForValidMovementRule(){
        PlateauService plateauService = new PlateauService(5,5);
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3,2, Direction.N);
        roverService.maneuveringRover("LRMLMRLMLRM",plateauService, obstacles);
        assertEquals(Direction.W,roverService.getRover().getPosition().getDirection());
        assertEquals(0,roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(3,roverService.getRover().getPosition().getCoordinates().getYCoordinate());
    }
    @Test
    public void checkManeuveringForInValidMovementRule(){
        PlateauService plateauService = new PlateauService(5,5);
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3,2, Direction.N);
        roverService.maneuveringRover("ABCUFTBSS",plateauService, obstacles);
        assertEquals(Direction.N,roverService.getRover().getPosition().getDirection());
        assertEquals(3,roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(2,roverService.getRover().getPosition().getCoordinates().getYCoordinate());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsNorthFacing(){
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3, 3, Direction.N);
        roverService.maneuveringRover("LMR", new PlateauService(5, 5), obstacles);
        assertEquals(2, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.N, roverService.getRover().getPosition().getDirection());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsSouthFacing(){
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3, 3, Direction.S);
        roverService.maneuveringRover("LMR", new PlateauService(5, 5), obstacles);
        assertEquals(4, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.S, roverService.getRover().getPosition().getDirection());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsEastFacing(){
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3, 3, Direction.E);
        roverService.maneuveringRover("LMR", new PlateauService(5, 5), obstacles);
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(4, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.E, roverService.getRover().getPosition().getDirection());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsWestFacing(){
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3, 3, Direction.W);
        roverService.maneuveringRover("LMR", new PlateauService(5, 5), obstacles);
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(2, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.W, roverService.getRover().getPosition().getDirection());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsNorthFacingAndAtTheBoundary(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3, 5, Direction.N);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(5, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.N, roverService.getRover().getPosition().getDirection());
        assertEquals("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsSouthFacingAndAtTheBoundary(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(3, 0, Direction.S);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(0, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.S, roverService.getRover().getPosition().getDirection());
        assertEquals("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsEastFacingAndAtTheBoundary(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(5, 3, Direction.E);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(5, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.E, roverService.getRover().getPosition().getDirection());
        assertEquals("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsWestFacingAndAtTheBoundary(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        RoverService roverService = new RoverService(0, 3, Direction.W);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(0, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.W, roverService.getRover().getPosition().getDirection());
        assertEquals("you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
            "you are already on the boundary of the plateau, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsNorthFacingAndIsAboutToHitAnObstacle(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        obstacles.add(new Coordinates(3,3));
        RoverService roverService = new RoverService(3, 2, Direction.N);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(2, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.N, roverService.getRover().getPosition().getDirection());
        assertEquals("you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsSouthFacingAndIsAboutToHitAnObstacle(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        obstacles.add(new Coordinates(3,3));
        RoverService roverService = new RoverService(3, 4, Direction.S);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(4, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.S, roverService.getRover().getPosition().getDirection());
        assertEquals("you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsEastFacingAndIsAboutToHitAnObstacle(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        obstacles.add(new Coordinates(3,3));
        RoverService roverService = new RoverService(2, 3, Direction.E);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(2, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.E, roverService.getRover().getPosition().getDirection());
        assertEquals("you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testManeuveringRoverWhenRoverIsWestFacingAndIsAboutToHitAnObstacle(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Coordinates> obstacles = new ArrayList<>();
        obstacles.add(new Coordinates(3,3));
        RoverService roverService = new RoverService(4, 3, Direction.W);
        roverService.maneuveringRover("MMM", new PlateauService(5, 5), obstacles);
        assertEquals(4, roverService.getRover().getPosition().getCoordinates().getXCoordinate());
        assertEquals(3, roverService.getRover().getPosition().getCoordinates().getYCoordinate());
        assertEquals(Direction.W, roverService.getRover().getPosition().getDirection());
        assertEquals("you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule\r\n" +
                "you are about to hit an obstacle, so the program is gonna skip this movement rule, M and try to action the next movement rule", outputStreamCaptor.toString()
                .trim());
    }
}
