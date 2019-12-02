package com.blablacar.mower.domain;

import com.blablacar.mower.domain.mower.Mower;
import com.blablacar.mower.domain.mower.Lawn;
import com.blablacar.mower.domain.mower.Orientation;
import com.blablacar.mower.domain.mower.Position;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefsMower {

    private Lawn lawn;
    private Mower mower;

    @Given("^Lawn has upper right corner \\((\\d+),(\\d+)\\)$")
    public void lawn_has_upper_right_corner(int upperCornerX, int upperCornerY) throws Throwable {
        lawn = new Lawn(upperCornerX, upperCornerY);
    }

    @Given("^the mower has position \\((\\d+),(\\d+)\\) and orientation \"([^\"]*)\"$")
    public void the_mower_has_position_and_orientation(int x, int y, String orientation) throws Throwable {
        mower = new Mower(
            new Position(x, y),
            Orientation.valueOf(orientation),
            this.lawn);
    }

    @When("^the Mower receives instructions \"([^\"]*)\"$")
    public void the_Mower_receives_instructions(String instructions) throws Throwable {
        this.mower.executeInstructions(instructions);
    }

    @Then("^the client Mower has new position \\((\\d+),(\\d+)\\) and orientation \"([^\"]*)\"$")
    public void the_client_Mower_has_new_position_and_orientation(int newX, int newY, String newOrientation) throws Throwable {
        assertThat(this.mower.getPosition())
            .isEqualTo(new Position(newX, newY));
        assertThat(this.mower.getOrientation())
            .isEqualTo(Orientation.valueOf(newOrientation));
    }

}