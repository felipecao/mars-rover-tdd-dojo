package com.github.felipecao.rover.command;

import com.github.felipecao.rover.input.Input;
import com.github.felipecao.rover.entity.Rover;

/**
 * Created by felipe on 26/11/15.
 */
public class TurnLeftCommand extends TurnCommand {

    public TurnLeftCommand(Rover r) {
        rover = r;
    }

    @Override
    public Input getDirection() {
        return Input.L;
    }
}
