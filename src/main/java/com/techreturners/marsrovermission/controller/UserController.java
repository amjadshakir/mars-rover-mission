package com.techreturners.marsrovermission.controller;

import com.techreturners.marsrovermission.service.UserService;

import java.util.Scanner;

public class UserController {
    public UserController(){
        UserService userService = new UserService(new Scanner(System.in));
        userService.handleUserInput();
    }
}

