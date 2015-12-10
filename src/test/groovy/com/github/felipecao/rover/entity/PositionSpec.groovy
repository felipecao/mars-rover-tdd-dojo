package com.github.felipecao.rover.entity

import spock.lang.Specification

/**
 * Created by felipe on 12/11/15.
 */
class PositionSpec extends Specification {

    def "position (1,2) is not the same as position (2,1)"(){
        given:
        Position p1 = new Position(1, 2)
        Position p2 = new Position(2, 1)

        when:
        boolean equals = p1.equals(p2)

        then:
        !equals
    }

    def "position (1,2) is the same as position (1,2)"(){
        given:
        Position p1 = new Position(1, 2)
        Position p2 = new Position(1, 2)

        when:
        boolean equals = p1.equals(p2)

        then:
        equals
    }

    def "position (1,2) has x = 1 and y = 2"(){
        when:
        Position p = new Position(1, 2)

        then:
        1 == p.x
        2 == p.y
    }

    def "move changes the position"(){
        expect:
        p == new Position(1, 2).move(orientation)

        where:
        p                  | orientation
        new Position(1, 3) | Orientation.NORTH
        new Position(0, 2) | Orientation.WEST
        new Position(1, 1) | Orientation.SOUTH
        new Position(2, 2) | Orientation.EAST
    }

}
