package com.blablacar.automower.domain.mower;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wassim on 01/12/2019.
 */
public class Automower {

    private static Logger logger = LoggerFactory.getLogger(Automower.class);

    private Position position;
    private Orientation orientation;
    private Lawn lawn;

    public Automower(Position position, Orientation orientation, Lawn lawn) {
        this.position = position;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    public void executeInstructions(String instructions) {

        instructions.codePoints()
            .mapToObj(inst -> String.valueOf((char) inst))
            .map(Instruction::valueOf)
            .forEach(this::executeOneInstruction);

    }

    private void executeOneInstruction(Instruction instruction) {
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
        this.orientation = this.orientation.turnOnRight();
    }

    private void turnOnLeft() {
        this.orientation = this.orientation.turnOnLeft();
    }

    private void goForward() {
        this.position = this.position.goForward(orientation, lawn);
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Automower{" +
            "position=" + position +
            ", orientation=" + orientation +
            '}';
    }
}
