Feature: Going forward
  Background:
    Given Lawn has upper right corner (5,5)

  Scenario Outline: Going forward
    Given the automower has position (1,1) and orientation "<orientation>"
    When the Automower receives instructions "F"
    Then the client Automower has new position (<newX>,<newY>) and orientation "<orientation>"
  Examples:
  | orientation | newX  | newY |
  | N           | 1     | 2    |
  | E           | 2     | 1    |
  | S           | 1     | 0    |
  | W           | 0     | 1    |
