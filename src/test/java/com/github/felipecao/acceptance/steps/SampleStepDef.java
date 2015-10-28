package com.github.felipecao.acceptance.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleStepDef {

    int orderedCoffees;
    int amount;

    @Given("^there are (\\d+) coffees left in the machine$")
    public void there_are_coffees_left_in_the_machine(int numberOfCoffees) throws Throwable {
        orderedCoffees = numberOfCoffees;
    }

    @Given("^I have deposited (\\d+)\\$$")
    public void I_have_deposited_$(int money) throws Throwable {
        amount = money;
    }

    @When("^I press the coffee button$")
    public void I_press_the_coffee_button() throws Throwable {
        return; // do nothing
    }

    @Then("^I should be served a coffee$")
    public void I_should_be_served_a_coffee() throws Throwable {
        return; // do nothing
    }
}
