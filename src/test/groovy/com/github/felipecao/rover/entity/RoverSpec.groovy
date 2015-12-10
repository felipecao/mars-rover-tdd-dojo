package com.github.felipecao.rover.entity

import com.github.felipecao.rover.entity.exception.IllegalPositionException
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by felipe on 29/10/15.
 */
@Unroll
class RoverSpec extends Specification {

    def "when setLandingPosition is called then the rover is positioned accordingly"() {
        given:
        Rover rover = new Rover(new Plateau(new Coordinates(5,5)))

        when:
        rover.setPosition(new Position(x, y))

        then:
        rover.getCurrentPosition() == new Position(x, y)

        where:
        x | y
        2 | 3
        3 | 3
        1 | 4
        5 | 5
    }

    def "when setLandingOrientation is called with #input then the rover is facing #output"() {
        given:
        Rover rover = new Rover()

        when:
        rover.setOrientation(Orientation.getEnum(input))

        then:
        rover.getOrientation() == output

        where:
        input | output
        'N'   | Orientation.NORTH
        'E'   | Orientation.EAST
        'W'   | Orientation.WEST
        'S'   | Orientation.SOUTH
    }

    def "when rover lands at position (1,2) facing N, the end position dependes on the sequence"() {
        given:
        Rover rover = new Rover(new Plateau(new Coordinates(5,5)))

        and:
        rover.setPosition(new Position(1, 2))
        rover.setOrientation(Orientation.getEnum("N"))

        when:
        rover.move(sequence)

        then:
        rover.currentPosition == finalPosition
        rover.orientation == finalOrientation

        where:
        sequence        | finalPosition      | finalOrientation
        "M"             | new Position(1, 3) | Orientation.NORTH
        "L"             | new Position(1, 2) | Orientation.WEST
        "R"             | new Position(1, 2) | Orientation.EAST
        "LM"            | new Position(0, 2) | Orientation.WEST
        "RM"            | new Position(2, 2) | Orientation.EAST
        "MM"            | new Position(1, 4) | Orientation.NORTH
        "MMM"           | new Position(1, 5) | Orientation.NORTH
        "LMLM"          | new Position(0, 1) | Orientation.SOUTH
        "LMLMLM"        | new Position(1, 1) | Orientation.EAST
        "LMLMLMLM"      | new Position(1, 2) | Orientation.NORTH
        "LMLMLMLMM"     | new Position(1, 3) | Orientation.NORTH
        "DLMLMLMLMM"    | new Position(1, 3) | Orientation.NORTH
        "DL ML MLM LMM" | new Position(1, 3) | Orientation.NORTH
    }

    def "when rover lands at position (#x,#y) facing N, and the plateau coordinates are (#pX,#pY), does setPosition raise an exception? #raise"() {
        given:
        Plateau plateau = new Plateau(new Coordinates(pX, pY))
        Rover rover = new Rover(plateau)
        IllegalPositionException ex

        when:
        try{
            rover.setOrientation(Orientation.getEnum("N"))
            rover.setPosition(new Position(x, y))
        }
        catch(IllegalPositionException e){
            ex = e
        }

        then:
        raise == (ex != null)

        where:
        pX | pY | x | y | raise
        5  | 5  | 5 | 6 | true
        5  | 5  | 6 | 6 | true
        4  | 4  | 6 | 6 | true
        4  | 4  | 5 | 5 | true
        4  | 4  | 3 | 3 | false
    }
}
