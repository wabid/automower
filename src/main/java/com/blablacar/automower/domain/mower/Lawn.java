package com.blablacar.automower.domain.mower;

/**
 * Created by wassim on 01/12/2019.
 */
public class Lawn {

    private final UpperRightCorner upperRightCorner;

    public Lawn(int upperRightCornerX, int upperRightCornerY) {
        upperRightCorner = new UpperRightCorner(upperRightCornerX, upperRightCornerY);
    }

    public UpperRightCorner getUpperRightCorner() {
        return upperRightCorner;
    }

    public boolean isOutside(Position position) {
        return position.getX() > this.upperRightCorner.getX()
            || position.getY() > this.upperRightCorner.getY()
            || position.getX() <0
            || position.getY() <0
            ;
    }
}
