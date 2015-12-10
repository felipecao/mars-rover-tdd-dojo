package com.github.felipecao.rover.entity;

import com.github.felipecao.rover.input.Input;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by felipe on 29/10/15.
 */
public enum Orientation {

    NORTH, WEST, SOUTH, EAST;

    private static List<Orientation> orderedCardinalPoints = new LinkedList<Orientation>();

    static {
        orderedCardinalPoints.add(NORTH);
        orderedCardinalPoints.add(EAST);
        orderedCardinalPoints.add(SOUTH);
        orderedCardinalPoints.add(WEST);
    }

    public static Orientation getEnum(String value) {
        switch (value) {
            case "N":
                return NORTH;
            case "E":
                return EAST;
            case "S":
                return SOUTH;
            case "W":
                return WEST;
            default:
                throw new IllegalArgumentException();
        }
    }

    public Orientation change(Input direction) {
        if (direction.equals(Input.R)) {
            return this.toTheRight();
        } else if (direction.equals(Input.L)) {
            return this.toTheLeft();
        }
        return this;
    }

    public Orientation toTheLeft() {
        return getAt(orderedCardinalPoints.indexOf(this) - 1, orderedCardinalPoints.size() - 1);
    }

    public Orientation toTheRight() {
        return getAt(orderedCardinalPoints.indexOf(this) + 1, 0);
    }

    private Orientation getAt(int desired, int fallback) {
        try {
            return orderedCardinalPoints.get(desired);
        } catch (IndexOutOfBoundsException e) {
            return orderedCardinalPoints.get(fallback);
        }
    }
}