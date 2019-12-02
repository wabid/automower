package com.blablacar.mower.domain.mower;

import java.util.Objects;

import static java.lang.String.format;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position goForward(Orientation orientation, Lawn lawn) {
        final Position newPosition;
        switch (orientation) {
            case N:
                newPosition = this.goNorth();
                break;
            case E:
                newPosition = this.goEast();
                break;
            case S:
                newPosition = this.goSouth();
                break;
            case W:
                newPosition = this.goWest();
                break;
            default:
                throw new RuntimeException(format("No operation found matching orientation : %s", orientation));
        }
        if (lawn.isOutside(newPosition)) {
            return this;
        } else {
            return newPosition;
        }
    }

    private Position goNorth() {
        return new Position(this.getX(),
            this.getY() + 1);
    }

    private Position goEast() {
        return new Position(this.getX() + 1,
            this.getY());
    }

    private Position goSouth() {
        return new Position(this.getX(),
            this.getY() - 1);
    }

    private Position goWest() {
        return new Position(this.getX() - 1,
            this.getY());
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
        return x + " " + y;
    }

}