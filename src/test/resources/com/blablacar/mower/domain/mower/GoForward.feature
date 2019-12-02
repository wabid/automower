Feature: Going forward

  Background:
    Given Lawn has upper right corner (5,5)

  Scenario Outline: Going forward
    Given the mower has position (1,1) and orientation "<orientation>"
    When the Mower receives instructions "F"
    Then the client Mower has new position (<newX>,<newY>) and orientation "<orientation>"
    Examples:
      | orientation | newX | newY |
      | N           | 1    | 2    |
      | E           | 2    | 1    |
      | S           | 1    | 0    |
      | W           | 0    | 1    |

  Scenario Outline: Keep position if the position after moving is outside the lawn
    Given the mower has position (<x>,<y>) and orientation "<orientation>"
    When the Mower receives instructions "F"
    Then the client Mower has new position (<x>,<y>) and orientation "<orientation>"
    Examples:
      | x | y | orientation |
      | 1 | 5 | N           |
      | 5 | 2 | E           |
      | 4 | 0 | S           |
      | 0 | 0 | W           |
