package com.techreturners.marsrovermission.controller;

import com.techreturners.marsrovermission.service.UserService;

import java.util.Scanner;

public class UserController {
    public UserController(){
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        userService.handleUserInput();
    }
    }

