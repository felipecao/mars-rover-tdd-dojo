Feature: Land rover on Mars
  A rover cannot land out of the plateau
  A rover cannot move out of the plateau

  Scenario: Land 2 rovers
    Given that the upper-right coordinates of the plateau are (5,5)
    And that 2 rovers will be landed
    And the first rover starts at position (1,2) facing "N"
    And the first rover should move according to the sequence "LMLMLMLMM"
    And the second rover starts at position (3,3) facing "E"
    And the second rover should move according to the sequence "MMRMMRMRRM"
    When the rovers finish the landing procedures
    Then the first rover is at position (1,3) facing "N"
    And the second rover is at position (5,1) facing "E"

  Scenario: land outside the plateau
    Given that the upper-right coordinates of the plateau that we are going to land outside are (5,5)
    When a rover lands at position (5,6) facing "N"
    Then the landing is not successful

  Scenario: land inside the plateau and move out of the plateau
    Given that the upper-right coordinates of the plateau we are going to move out of are (5,5)
    When our rover lands at position (4,4) facing "N"
    And our rover should move according to the sequence "MM"
    Then the rover falls out of the plateau

  Scenario: land 3 rovers
    Given that the upper-right coordinates of the plateau are (5,5)
    And that 3 rovers will be landed
    And the first rover starts at position (1,2) facing "N"
    And the first rover should move according to the sequence "LMLMLMLMM"
    And the second rover starts at position (3,3) facing "E"
    And the second rover should move according to the sequence "MMRMMRMRRM"
    And the third rover starts at position (1,1) facing "N"
    And the third rover should move according to the sequence "MLMLMLML"
    When the rovers finish the landing procedures
    Then the first rover is at position (1,3) facing "N"
    And the second rover is at position (5,1) facing "E"
    And the third rover is at position (1,1) facing "N"