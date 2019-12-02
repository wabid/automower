Feature: Execute a mower program

  Scenario: Execute a mower program
    Given the mower program
"""
5 5
1 2 N
LFLFLFLFF
3 3 E
FFRFFRFRRF
"""
    When the mower program has been executed
    Then the output of the program is
"""
1 3 N
5 1 E

"""
