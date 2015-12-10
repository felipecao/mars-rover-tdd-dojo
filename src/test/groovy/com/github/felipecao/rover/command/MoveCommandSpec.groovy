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
class MoveCommandSpec extends Specification {

    def "if a rover lies at position (#initialX,#initialY) facing #initialO, when we move it, the new position is (#finalX,#finalY) facing #finalO"() {
        given:
        Rover rover = new Rover(new Plateau(new Coordinates(5, 5)))
        rover.setPosition(new Position(initialX, initialY))
        rover.setOrientation(Orientation.getEnum(initialO))

        and:
        Command move = new MoveCommand(rover)

        when:
        move.execute()

        then:
        finalX == rover.currentPosition.x
        finalY == rover.currentPosition.y
        finalO == rover.orientation

        where:
        initialX | initialY | initialO | finalX | finalY | finalO
        1        | 2        | "N"      | 1      | 3      | Orientation.NORTH
        1        | 2        | "S"      | 1      | 1      | Orientation.SOUTH
        1        | 2        | "W"      | 0      | 2      | Orientation.WEST
        1        | 2        | "E"      | 2      | 2      | Orientation.EAST
        0        | 0        | "E"      | 1      | 0      | Orientation.EAST
        0        | 0        | "N"      | 0      | 1      | Orientation.NORTH
    }

}
