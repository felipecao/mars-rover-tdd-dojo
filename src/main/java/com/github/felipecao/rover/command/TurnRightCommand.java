package com.github.felipecao.rover.command;

import com.github.felipecao.rover.input.Input;
import com.github.felipecao.rover.entity.Rover;

/**
 * Created by felipe on 26/11/15.
 */
public class TurnRightCommand extends TurnCommand {

    public TurnRightCommand(Rover r) {
        rover = r;
    }

    @Override
    public Input getDirection() {
        return Input.R;
    }
}
