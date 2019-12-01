Feature: Execute instructions
  Background:
    Given Lawn has upper right corner (5,5)

  Scenario Outline: Going forward
    Given the automower has position (<x>,<y>) and orientation "<orientation>"
    When the Automower receives instructions "<instructions>"
    Then the client Automower has new position (<newX>,<newY>) and orientation "<newOrientation>"
  Examples:
  | x   | y     | orientation | instructions 	| newX  | newY  | newOrientation 	|
  | 1   | 2  	| N           | LFLFLFLFF     	| 1    	| 3     | N 				|
  | 3   | 3  	| E           | FFRFFRFRRF     	| 5    	| 1     | E 				|
