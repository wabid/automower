package com.blablacar.mower.domain;

import com.blablacar.mower.application.MowerProgramExecutor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefsExecuteMowerProgram {

    private MowerProgramExecutor mowerProgramExecutor;
    private String output;

    @Given("^the mower program$")
    public void the_mower_program(String program) throws Throwable {
        mowerProgramExecutor = new MowerProgramExecutor(program);
    }

    @When("^the mower program has been executed$")
    public void the_mower_program_has_been_executed() throws Throwable {
        output = this.mowerProgramExecutor.execute();
    }

    @Then("^the output of the program is$")
    public void the_output_of_the_program_is(String output) throws Throwable {
        assertThat(this.output).isEqualTo(output);
    }
}