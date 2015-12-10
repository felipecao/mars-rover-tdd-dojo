package com.github.felipecao.acceptance.steps

import com.github.felipecao.rover.entity.*
import com.github.felipecao.rover.entity.exception.IllegalPositionException
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

/**
 * Created by felipe on 10/12/15.
 */
class MoveOutOfPlateauStepDefs {

    Plateau plateau
    Rover rover
    IllegalPositionException exception

    @Given('^that the upper-right coordinates of the plateau we are going to move out of are \\((\\d+),(\\d+)\\)$')
    public void that_the_upper_right_coordinates_of_the_plateau_are_(int x, int y) throws Throwable {
        plateau = new Plateau(new Coordinates(x, y))
        rover = new Rover(plateau)
    }

    @When('^our rover lands at position \\((\\d+),(\\d+)\\) facing \"([^\"]*)\"$')
    public void a_rover_lands_at_position_facing(int x, int y, String orientation) throws Throwable {
        rover.setPosition(new Position(x, y))
        rover.setOrientation(Orientation.getEnum(orientation))
    }

    @When("^our rover should move according to the sequence \"([^\"]*)\"\$")
    public void the_second_rover_should_move_according_to_the_sequence(String sequence) throws Throwable {
        try {
            rover.move(sequence)
        }
        catch (IllegalPositionException ex) {
            exception = ex
        }
    }

    @Then('^the rover falls out of the plateau$')
    public void the_landing_is_not_successful() throws Throwable {
        assert exception != null
    }
}
