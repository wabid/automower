package com.blablacar.automower.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

/**
 * Created by wassim on 01/12/2019.
 */
public class Lawn {

    public Lawn(int upperRightCornerX, int upperRightCornerY) {
        new UpperRightCorner( upperRightCornerX, upperRightCornerY);
    }

    private class UpperRightCorner {
        @Positive
        private int x;
        @Positive
        private int y;
        public UpperRightCorner(int upperRightCornerX, int upperRightCornerY) {
            x = upperRightCornerX;
            y = upperRightCornerY;
        }
    }
}
