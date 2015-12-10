package com.github.felipecao.acceptance.steps

import com.github.felipecao.rover.entity.Coordinates
import com.github.felipecao.rover.entity.exception.IllegalPositionException
import com.github.felipecao.rover.entity.Orientation
import com.github.felipecao.rover.entity.Plateau
import com.github.felipecao.rover.entity.Position
import com.github.felipecao.rover.entity.Rover
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

/**
 * Created by felipe on 10/12/15.
 */
class LandOutsidePlateauStepDefs {

    Plateau plateau
    Rover rover
    IllegalPositionException exception

    @Given('^that the upper-right coordinates of the plateau that we are going to land outside are \\((\\d+),(\\d+)\\)$')
    public void that_the_upper_right_coordinates_of_the_plateau_are_(int x, int y) throws Throwable {
        plateau = new Plateau(new Coordinates(x, y))
        rover = new Rover(plateau)
    }

    @When('^a rover lands at position \\((\\d+),(\\d+)\\) facing \"([^\"]*)\"$')
    public void a_rover_lands_at_position_facing(int x, int y, String orientation) throws Throwable {
        try {
            rover.setPosition(new Position(x, y))
            rover.setOrientation(Orientation.getEnum(orientation))
        }
        catch(IllegalPositionException ex){
            exception = ex
        }
    }

    @Then('^the landing is not successful$')
    public void the_landing_is_not_successful() throws Throwable {
        assert exception != null
    }
}
