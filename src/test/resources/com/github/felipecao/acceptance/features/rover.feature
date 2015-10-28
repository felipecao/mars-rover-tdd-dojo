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