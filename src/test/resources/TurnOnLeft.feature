Feature: Turn on left
  Background:
    Given Lawn has upper right corner (5,5)

  Scenario Outline: Turn on left
    Given the automower has position (1,1) and orientation "<orientation>"
    When the Automower receives instructions "L"
    Then the client Automower has new position (1,1) and orientation "<newOrientation>"
  Examples:
  | orientation | newOrientation |
  | N           | W              |
  | E           | N              |
  | S           | E              |
  | W           | S              |