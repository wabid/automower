package com.blablacar.automower;

import com.blablacar.automower.domain.Automower;
import com.blablacar.automower.domain.Lawn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefsGoForward {

    private Lawn lawn;
    private Automower automower;

    @Given("^Lawn has upper right corner \\((\\d+),(\\d+)\\)$")
    public void lawn_has_upper_right_corner(int upperCornerX, int upperCornerY) throws Throwable {
        lawn = new Lawn(upperCornerX, upperCornerY);
    }

    @Given("^the automower has position \\((\\d+),(\\d+)\\) and orientation \"([^\"]*)\"$")
    public void the_automower_has_position_and_orientation(int x, int y, String orientation) throws Throwable {
        automower = new Automower(x, y, orientation);
    }

    @When("^the Automower receives instructions \"([^\"]*)\"$")
    public void the_Automower_receives_instructions(String instructions) throws Throwable {
        this.automower.executeInstructions(instructions);
    }

    @Then("^the client Automower has new position \\((\\d+),(\\d+)\\) and orientation \"([^\"]*)\"$")
    public void the_client_Automower_has_new_position_and_orientation(int newX, int newY, String newOrientation) throws Throwable {
        assertThat(this.automower.getPosition())
            .isEqualTo(new Automower.Position(newX, newY));
        assertThat(this.automower.getOrientation())
            .isEqualTo(Automower.Orientation.valueOf(newOrientation));
    }

}