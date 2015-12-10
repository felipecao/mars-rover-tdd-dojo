package com.github.felipecao.acceptance.steps

import com.github.felipecao.rover.entity.Coordinates
import com.github.felipecao.rover.entity.Orientation
import com.github.felipecao.rover.entity.Plateau
import com.github.felipecao.rover.entity.Position
import com.github.felipecao.rover.entity.Rover
import cucumber.api.PendingException
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import static org.junit.Assert.assertEquals

/**
 * Created by felipe on 29/10/15.
 */
class LandTwoRoversStepDefs {

    Plateau plateau
    List<Rover> rovers = []

    @Given("^that the upper-right coordinates of the plateau are \\((\\d+),(\\d+)\\)\$")
    public void that_the_upper_right_coordinates_of_the_plateau_are_(int x, int y) throws Throwable {
        plateau = new Plateau(new Coordinates(x,y))
    }

    @Given("^that (\\d+) rovers will be landed\$")
    public void that_rovers_will_be_landed(int n) throws Throwable {
        (1..n).each {
            rovers << new Rover(plateau)
        }
    }

    @Given("^the first rover starts at position \\((\\d+),(\\d+)\\) facing \"([^\"]*)\"\$")
    public void the_first_rover_starts_at_position_facing(int x, int y, String orientation) throws Throwable {
        rovers.first().setPosition(new Position(x, y))
        rovers.first().setOrientation(Orientation.getEnum(orientation))
    }

    @Given("^the first rover should move according to the sequence \"([^\"]*)\"\$")
    public void the_first_rover_should_move_according_to_the_sequence(String sequence) throws Throwable {
        rovers.first().move(sequence)
    }

    @Given("^the second rover starts at position \\((\\d+),(\\d+)\\) facing \"([^\"]*)\"\$")
    public void the_second_rover_starts_at_position_facing(int x, int y, String orientation) throws Throwable {
        rovers.last().setPosition(new Position(x, y))
        rovers.last().setOrientation(Orientation.getEnum(orientation))
    }

    @Given("^the second rover should move according to the sequence \"([^\"]*)\"\$")
    public void the_second_rover_should_move_according_to_the_sequence(String sequence) throws Throwable {
        rovers.last().move(sequence)
    }

    @When("^the rovers finish the landing procedures\$")
    public void the_rovers_finish_the_landing_procedures() throws Throwable {
        // do nothing
    }

    @Then("^the first rover is at position \\((\\d+),(\\d+)\\) facing \"([^\"]*)\"\$")
    public void the_first_rover_is_at_position_facing(int x, int y, String orientation) throws Throwable {
        assertEquals(x, rovers.first().currentPosition.x)
        assertEquals(y, rovers.first().currentPosition.y)
        assertEquals(Orientation.getEnum(orientation), rovers.first().orientation)
    }

    @Then("^the second rover is at position \\((\\d+),(\\d+)\\) facing \"([^\"]*)\"\$")
    public void the_second_rover_is_at_position_facing(int x, int y, String orientation) throws Throwable {
        assertEquals(x, rovers.last().currentPosition.x)
        assertEquals(y, rovers.last().currentPosition.y)
        assertEquals(Orientation.getEnum(orientation), rovers.last().orientation)
    }
}
