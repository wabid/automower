package com.blablacar.automower.domain.mower;

import javax.validation.constraints.Positive;

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

}