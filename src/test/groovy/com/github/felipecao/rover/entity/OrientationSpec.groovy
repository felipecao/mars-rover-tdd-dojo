package com.github.felipecao.rover.entity

import com.github.felipecao.rover.input.Input
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class OrientationSpec extends Specification {

    def 'when getEnum is called with #input it returns the #output enum'() {
        expect:
        output == Orientation.getEnum(input)

        where:
        input | output
        'N'   | Orientation.NORTH
        'E'   | Orientation.EAST
        'W'   | Orientation.WEST
        'S'   | Orientation.SOUTH
    }

    def 'when getEnum is called with G it throws an exception'() {
        when:
        Orientation.getEnum('G')

        then:
        thrown(IllegalArgumentException)
    }

    def "#currentOrientation knows that #nextOrientation lies at its #direction"() {
        expect:
        nextOrientation == currentOrientation.change(direction)

        where:
        currentOrientation | direction  | nextOrientation
        Orientation.NORTH  | Input.L | Orientation.WEST
        Orientation.NORTH  | Input.R | Orientation.EAST
        Orientation.SOUTH  | Input.R | Orientation.WEST
        Orientation.SOUTH  | Input.L | Orientation.EAST
        Orientation.EAST   | Input.L | Orientation.NORTH
        Orientation.EAST   | Input.R | Orientation.SOUTH
        Orientation.WEST   | Input.R | Orientation.NORTH
        Orientation.WEST   | Input.L | Orientation.SOUTH
        Orientation.NORTH  | Input.M | Orientation.NORTH
        Orientation.SOUTH  | Input.M | Orientation.SOUTH
        Orientation.WEST   | Input.M | Orientation.WEST
        Orientation.EAST   | Input.M | Orientation.EAST
    }
}
