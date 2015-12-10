package com.github.felipecao.rover.command;

import com.github.felipecao.rover.entity.Rover;

/**
 * Created by felipe on 26/11/15.
 */
public class MoveCommand implements Command {

    private Rover rover;

    public MoveCommand(Rover r) {
        rover = r;
    }

    @Override
    public void execute() {
        rover.setPosition(rover.getCurrentPosition().move(rover.getOrientation()));
    }
}
