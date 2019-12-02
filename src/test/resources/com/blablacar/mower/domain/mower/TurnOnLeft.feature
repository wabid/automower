Feature: Turn on left
  Background:
    Given Lawn has upper right corner (5,5)

  Scenario Outline: Turn on left
    Given the mower has position (1,1) and orientation "<orientation>"
    When the Mower receives instructions "L"
    Then the client Mower has new position (1,1) and orientation "<newOrientation>"
  Examples:
  | orientation | newOrientation |
  | N           | W              |
  | E           | N              |
  | S           | E              |
  | W           | S              |