package com.github.felipecao.rover.entity

import com.github.felipecao.rover.input.Input
import spock.lang.Specification

/**
 * Created by felipe on 12/11/15.
 */
class InputTest extends Specification {

    def "valueOf works as expected"(){
        expect:
        movement == Input.valueOf(input)

        where:
        input | movement
        "M"   | Input.M
        "L"   | Input.L
        "R"   | Input.R
    }

    def "valueOf throwns an exception if input is not M, L or R"(){
        when:
        Input.valueOf("G")

        then:
        thrown(IllegalArgumentException)
    }
}
