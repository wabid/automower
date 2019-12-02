package com.blablacar.mower.domain.mower;

/**
 * Created by wassim on 02/12/2019.
 */

public enum Orientation {

    N, E, S, W;

    public Orientation turnOnRight() {
        return Orientation.values()[(this.ordinal()+1) % 4];
    }

    public Orientation turnOnLeft() {
        return  Orientation.values()[(this.ordinal()+3) % 4];
    }
}


