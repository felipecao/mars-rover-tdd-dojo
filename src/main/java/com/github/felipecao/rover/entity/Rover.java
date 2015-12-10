package com.github.felipecao.rover.entity;

import com.github.felipecao.rover.command.*;
import com.github.felipecao.rover.entity.exception.IllegalPositionException;

/**
 * Created by felipe on 29/10/15.
 */
public class Rover {

    private Orientation orientation;
    private Position position;
    private Plateau plateau;

    public Rover(Plateau p) {
        this.plateau = p;
    }

    public void move(String sequence) {

        Command command = null;
        CommandFactory commandFactory = new CommandFactory(this);

        for (String m : sequence.split("")) {
            command = commandFactory.build(m);
            command.execute();
        }
    }

    public void setPosition(Position position) {
        makeSureRoverWontFallOutOfThePlateau(position);
        this.position = position;
    }

    private void makeSureRoverWontFallOutOfThePlateau(Position position){
        if (position.getX() > plateau.getUpperRightCoordinates().getX() ||
                position.getY() > plateau.getUpperRightCoordinates().getY()) {
            throw new IllegalPositionException();
        }
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Position getCurrentPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
