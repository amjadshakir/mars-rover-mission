package com.techreturners.marsrovermission.service;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    @Test
    public void testWithValidInputForValidateMovementRules() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        boolean result = userService.validateMovementRules("LMMLR");
        assertEquals(false, result);
    }
    @Test
    public void testWithInvalidInputForValidateMovementRules() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        boolean result = userService.validateMovementRules("abcde");
        assertEquals("You have entered an invalid value for the rover movement rules. Please enter a valid value Eg: LMLMLLMMM", outputStreamCaptor.toString()
                .trim());
        assertEquals(true, result);
    }
    @Test
    public void testValidInputForThePlateau() {
        String input = "5\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int result = userService.handleUserInputForCoordinateValueForThePlateau("X");
        assertEquals("Please enter the X coordinate (max) for the plateau", outputStreamCaptor.toString()
                .trim());
        assertEquals(5, result);
    }
    @Test
    public void testNegativeInputThenValidInputForThePlateau() {
        String input = "-1\n3\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int result = userService.handleUserInputForCoordinateValueForThePlateau("Y");

        assertEquals("Please enter the Y coordinate (max) for the plateau\r\n" +
                "You have entered a negative number or zero for the Y coordinate: -1. Please enter a valid integer value.", outputStreamCaptor.toString()
                .trim());
        assertEquals(3, result);
    }
    @Test
    public void testZeroInputThenValidInputForThePlateau() {
        String input = "0\n3\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int result = userService.handleUserInputForCoordinateValueForThePlateau("Y");
        assertEquals("Please enter the Y coordinate (max) for the plateau\r\n" +
                "You have entered a negative number or zero for the Y coordinate: 0. Please enter a valid integer value.", outputStreamCaptor.toString()
                .trim());
        assertEquals(3, result);
    }
    @Test
    public void testNonIntegerInputForThePlateau() {
        String input = "abc\n3\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int result = userService.handleUserInputForCoordinateValueForThePlateau("Y");
        assertEquals("Please enter the Y coordinate (max) for the plateau\r\n" +
                "You did not enter an int value for the Y coordinate. Please enter a valid integer value.\r\n" +
                "Please enter the Y coordinate (max) for the plateau", outputStreamCaptor.toString()
                .trim());
        assertEquals(3, result);
    }
    @Test
    public void testValidInputForTheRover() {
        String input = "4\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int result = userService.handleUserInputCoordinateValueForTheRoverPosition("X", 5);
        assertEquals("Please enter the X coordinate for the rover position", outputStreamCaptor.toString()
                .trim());
        assertEquals(4, result);
    }
    @Test
    public void testNegativeInputThenValidInputForTheRover() {
        String input = "-1\n3\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int result = userService.handleUserInputCoordinateValueForTheRoverPosition("X", 5);
        assertEquals("Please enter the X coordinate for the rover position\r\n" +
                "You entered a negative number or number greater than plateau size for the X coordinate, -1 of rover position. Please enter a valid integer value.", outputStreamCaptor.toString()
                .trim());
        assertEquals(3, result);
    }
    @Test
    public void testNonIntegerInputForTheRover() {
        String input = "abc\n3\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int result = userService.handleUserInputCoordinateValueForTheRoverPosition("Y", 5);
        assertEquals("Please enter the Y coordinate for the rover position\r\n" +
                "You did not enter an int value for the Y coordinate of rover position. Please enter a valid integer value.\r\n" +
                "Please enter the Y coordinate for the rover position", outputStreamCaptor.toString()
                .trim());
        assertEquals(3, result);
    }
    @Test
    public void testValidDirectionInputForTheRover() {
        String input = "N"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String result = userService.handleUserInputDirectionValueForRoverPosition();
        assertEquals("Enter the direction of the rover. eg. N or S or E or W", outputStreamCaptor.toString()
                .trim());
        assertEquals("N", result);
    }
    @Test
    public void testInvalidDirectionInputThenValidInputForTheRover() {
        String input = "-acv\nN\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String result = userService.handleUserInputDirectionValueForRoverPosition();
        assertEquals("Enter the direction of the rover. eg. N or S or E or W\r\n" +
                "You entered an invalid value for the direction: -ACV. Please enter a valid value. Please note that the direction can be either N or S or E or W.", outputStreamCaptor.toString()
                .trim());
        assertEquals("N", result);
    }
    @Test
    public void testIntegerDirectionInputForTheRover() {
        String input = "-1\nN\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String result = userService.handleUserInputDirectionValueForRoverPosition();
        assertEquals("Enter the direction of the rover. eg. N or S or E or W\r\n" +
                "You entered an invalid value for the direction: -1. Please enter a valid value. Please note that the direction can be either N or S or E or W.", outputStreamCaptor.toString()
                .trim());
        assertEquals("N", result);
    }
    @Test
    public void testValidInputForTheMovementRules() {
        String input = "MMMLLRR\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String result = userService.handleUserInputForMovementRules();
        assertEquals("Enter the movement rules on the plateau. Please note you can enter only values L, R or M. eg  LMMRLLM", outputStreamCaptor.toString()
                .trim());
        assertEquals("MMMLLRR", result);
    }
    @Test
    public void testInvalidInputThenValidInputForTheMovementRules() {
        String input = "abcde\nLMR\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String result = userService.handleUserInputForMovementRules();
        assertEquals("Enter the movement rules on the plateau. Please note you can enter only values L, R or M. eg  LMMRLLM\r\n" +
                "You have entered an invalid value for the rover movement rules. Please enter a valid value Eg: LMLMLLMMM", outputStreamCaptor.toString()
                .trim());
        assertEquals("LMR", result);
    }
}
