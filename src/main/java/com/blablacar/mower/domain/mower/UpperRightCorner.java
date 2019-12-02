package com.blablacar.mower.domain.mower;

import javax.validation.constraints.Positive;
import java.util.Objects;

public class UpperRightCorner {
        @Positive
        private int x;
        @Positive
        private int y;
        public UpperRightCorner(int upperRightCornerX, int upperRightCornerY) {
            x = upperRightCornerX;
            y = upperRightCornerY;
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
        UpperRightCorner that = (UpperRightCorner) o;
        return x == that.x &&
            y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}