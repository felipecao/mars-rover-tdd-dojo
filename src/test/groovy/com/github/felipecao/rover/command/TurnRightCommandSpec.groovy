package com.github.felipecao.rover.command

import com.github.felipecao.rover.entity.Coordinates
import com.github.felipecao.rover.entity.Orientation
import com.github.felipecao.rover.entity.Plateau
import com.github.felipecao.rover.entity.Position
import com.github.felipecao.rover.entity.Rover
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by felipe on 26/11/15.
 */
@Unroll
class TurnRightCommandSpec extends Specification {
    def "if a rover lies at position (#initialX,#initialY) facing #initialO, when we turn right, the next position is (#initialX,#initialY) facing #finalO"() {
        given:
        Rover rover = new Rover(new Plateau(new Coordinates(5, 5)))
        rover.setPosition(new Position(initialX, initialY))
        rover.setOrientation(Orientation.getEnum(initialO))

        and:
        Command rightCommand = new TurnRightCommand(rover)

        when:
        rightCommand.execute()

        then:
        initialX == rover.currentPosition.x
        initialY == rover.currentPosition.y
        finalO == rover.orientation

        where:
        initialX | initialY | initialO | finalO
        1        | 2        | "N"      | Orientation.EAST
        1        | 2        | "E"      | Orientation.SOUTH
        1        | 2        | "W"      | Orientation.NORTH
        1        | 2        | "S"      | Orientation.WEST
    }
}
