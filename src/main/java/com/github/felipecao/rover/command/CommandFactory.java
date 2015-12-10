package com.github.felipecao.rover.command;

import com.github.felipecao.rover.input.Input;
import com.github.felipecao.rover.entity.Rover;

/**
 * Created by felipe on 26/11/15.
 */
public class CommandFactory {

    private Rover rover;

    public CommandFactory(Rover rover) {
        this.rover = rover;
    }

    public Command build(String input) {
        Input i = convertFromString(input);

        if (null == i) {
            return new InvalidCommand();
        }

        return buildCommand(i);
    }

    private Input convertFromString(String input) {
        if (null == input) {
            return null;
        }
        try {
            return Input.valueOf(input.trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Command buildCommand(Input input) {
        switch (input) {
            case L:
                return new TurnLeftCommand(rover);
            case R:
                return new TurnRightCommand(rover);
            case M:
                return new MoveCommand(rover);
            default:
                return new InvalidCommand();
        }
    }
}
