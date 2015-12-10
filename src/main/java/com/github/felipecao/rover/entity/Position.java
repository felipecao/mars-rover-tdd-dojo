package com.github.felipecao.rover.entity;

/**
 * Created by felipe on 29/10/15.
 */
public class Position extends Coordinates {

    public Position(Integer x, Integer y) {
        super(x,y);
    }

    public Position move(Orientation orientation){
        switch (orientation) {
            case NORTH:
                return new Position(x, y + 1);
            case WEST:
                return new Position(x - 1, y);
            case SOUTH:
                return new Position(x, y - 1);
            case EAST:
                return new Position(x + 1, y);
        }
        return this;
    }
}
