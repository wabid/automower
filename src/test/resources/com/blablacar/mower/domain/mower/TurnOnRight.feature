Feature: Turn on right
  Background:
    Given Lawn has upper right corner (5,5)

  Scenario Outline: Turn on right
    Given the mower has position (1,1) and orientation "<orientation>"
    When the Mower receives instructions "R"
    Then the client Mower has new position (1,1) and orientation "<newOrientation>"
  Examples:
  | orientation | newOrientation |
  | N           | E              |
  | E           | S              |
  | S           | W              |
  | W           | N              |