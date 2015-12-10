package com.github.felipecao.rover.entity;

import com.github.felipecao.rover.entity.exception.PlateauInitializationException;

/**
 * Created by felipe on 29/10/15.
 */
public class Plateau {

    private Coordinates upperRight;

    public Plateau(Coordinates upperRightCoordinates) {
        makeSurePlateauCoordinatesAreNotNegative(upperRightCoordinates);
        upperRight = upperRightCoordinates;
    }

    public Coordinates getUpperRightCoordinates() {
        return upperRight;
    }

    private void makeSurePlateauCoordinatesAreNotNegative(Coordinates upperRightCoordinates){
        if (upperRightCoordinates.getX() < 0 || upperRightCoordinates.getY() < 0) {
            throw new PlateauInitializationException();
        }
    }
}
