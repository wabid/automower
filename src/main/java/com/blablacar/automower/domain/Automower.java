package com.blablacar.automower.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Created by wassim on 01/12/2019.
 */
public class Automower {

    Logger logger = LoggerFactory.getLogger(Automower.class);

    private Position position;
    private Orientation orientation;

    public enum Instruction{
        F,L,R
    }

    public Automower(int x, int y, String orientation_) {
        position = new Position(x, y);
        orientation = Orientation.valueOf(orientation_);
    }

    public void executeInstructions(String instructions) {

        instructions.codePoints()
            .mapToObj(inst -> String.valueOf((char) inst))
            .map(Instruction::valueOf)
            .forEach(this::excecuteOneInstruction);

    }

    private void excecuteOneInstruction(Instruction instruction) {
        switch (instruction) {
            case F:
                goForward();
                break;
            case L:
                turnOnLeft();
                break;
            case R:
                turnOnRight();
                break;
        }
        logger.info("instruction : {}, automower : {}", instruction, this);
    }

    private void turnOnRight() {
        this.orientation = Orientation.values()[(this.orientation.ordinal()+1) % 4];
    }

    private void turnOnLeft() {
        this.orientation = Orientation.values()[(this.orientation.ordinal()+3) % 4];
    }

    private void goForward() {
        switch (this.orientation) {
            case N:
                this.position = new Position(this.position.getX(),
                    this.position.getY() + 1);
                break;
            case E:
                this.position = new Position(this.position.getX() + 1,
                    this.position.getY());
                break;
            case S:
                this.position = new Position(this.position.getX() ,
                    this.position.getY()-1);
                break;
            case W:
                this.position = new Position(this.position.getX() -1,
                    this.position.getY());
                break;
        }
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public enum Orientation {
        N, E, S, W
    }

    public static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }
    }

    @Override
    public String toString() {
        return "Automower{" +
                "position=" + position +
                ", orientation=" + orientation +
                '}';
    }
}
