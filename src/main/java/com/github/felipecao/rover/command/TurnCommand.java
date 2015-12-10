package com.github.felipecao.rover.command;

import com.github.felipecao.rover.input.Input;
import com.github.felipecao.rover.entity.Rover;

/**
 * Created by felipe on 26/11/15.
 */
public abstract class TurnCommand implements Command {
    protected Rover rover;

    public abstract Input getDirection();

    @Override
    public void execute() {
        rover.setOrientation(rover.getOrientation().change(getDirection()));
    }
}
