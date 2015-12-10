package com.github.felipecao.rover.command

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by felipe on 26/11/15.
 */
@Unroll
class CommandFactorySpec extends Specification {

    def "when the input is #input build returns an instance of #concreteClass"() {
        given:
        CommandFactory commandFactory = new CommandFactory()

        when:
        def response = commandFactory.build(input)

        then:
        response.class == concreteClass

        where:
        input | concreteClass
        "M"   | MoveCommand
        "L"   | TurnLeftCommand
        "R"   | TurnRightCommand
        "D"   | InvalidCommand
        ""    | InvalidCommand
        "   " | InvalidCommand
        null  | InvalidCommand
    }
}
