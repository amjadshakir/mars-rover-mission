package com.techreturners.marsrovermission.service;

import com.techreturners.marsrovermission.model.Coordinates;
import com.techreturners.marsrovermission.model.Plateau;
public class PlateauService {
    private Plateau plateau;
    private Coordinates maxCoordinates;
    public PlateauService(int xCoordinate, int yCoordinate) {
        maxCoordinates = new Coordinates(xCoordinate, yCoordinate);
        plateau = new Plateau(maxCoordinates);
    }
    public Plateau getPlateau() {
        return plateau;
    }
    public Coordinates getMaxCoordinates() {
        return maxCoordinates;
    }
}