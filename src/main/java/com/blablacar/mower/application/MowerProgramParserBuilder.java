package com.blablacar.mower.application;

import com.blablacar.mower.domain.mower.Mower;
import com.blablacar.mower.domain.mower.Lawn;
import com.blablacar.mower.domain.mower.Orientation;
import com.blablacar.mower.domain.mower.Position;

import java.util.Scanner;

/**
 * Created by wassim on 02/12/2019.
 */
public class MowerProgramParserBuilder {

    public Lawn buildLawn(String line, int lineNumber) {
        checkLine(line, "\\d+ \\d+", lineNumber);
        Scanner scanner = new Scanner(line);
        int upperRightCornerX =  scanner.nextInt();
        int upperRightCornerY =  scanner.nextInt();
        return new Lawn(upperRightCornerX, upperRightCornerY);
    }

    private void checkLine(String line, String pattern, int lineNumber) {
        if(!line.matches(pattern)){
            throw new RuntimeException("An error occurred while parsing line " + lineNumber + " : "+ line);
        }
    }
    public Mower buildMower(String line, Lawn lawn, int lineNumber) {
        checkLine(line, "\\d+ \\d+ [NESW]", lineNumber);
        Scanner scanner = new Scanner(line);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String orientation = scanner.next();
        return new Mower(new Position(x, y), Orientation.valueOf(orientation), lawn);
    }

    public String buildInstructions(String line, int lineNumber) {
        checkLine(line, "[LRF]+", lineNumber);
        return line;
    }
}
