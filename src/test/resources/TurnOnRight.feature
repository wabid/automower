Feature: Turn on right
  Background:
    Given Lawn has upper right corner (5,5)

  Scenario Outline: Turn on right
    Given the automower has position (1,1) and orientation "<orientation>"
    When the Automower receives instructions "R"
    Then the client Automower has new position (1,1) and orientation "<newOrientation>"
  Examples:
  | orientation | newOrientation |
  | N           | E              |
  | E           | S              |
  | S           | W              |
  | W           | N              |