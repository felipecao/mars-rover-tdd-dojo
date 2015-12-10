package com.github.felipecao.rover.entity

import com.github.felipecao.rover.entity.exception.PlateauInitializationException
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by felipe on 10/12/15.
 */
@Unroll
class PlateauSpec extends Specification {

    def "when plateau is initialized with (#x,#y), its upper-right coordinates are (#x,#y)"() {
        expect:
        new Plateau(new Coordinates(x, y)).upperRightCoordinates == new Coordinates(x, y)

        where:
        x | y
        5 | 5
        5 | 6
        6 | 6
        0 | 0
        1 | 0
        1 | 1
    }

    def "when plateau is initialized with (#x,#y), it throws an PlateauInitializationException"() {
        when:
        new Plateau(new Coordinates(x, y))

        then:
        thrown(PlateauInitializationException)

        where:
        x  | y
        -1 | 0
        -1 | -1
        0  | -1
        -2 | -1
        -2 | -2
        -7 | -3
    }
}
