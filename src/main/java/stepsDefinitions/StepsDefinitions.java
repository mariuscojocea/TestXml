package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;
import stepLib.Steps;

import javax.xml.bind.JAXBException;

public class StepsDefinitions {

    @Shared
    Steps steps;

    @Given("^I have (.*) XML file")
    public void getFile(String file) throws JAXBException {
        steps.xmlFilePath(file);
    }

    @And("^The XML file is valid")
    public void validateXml() {
        //Add in a @Before
    }

    @When("^I verify the debtor total amount")
    public void verifyTotalAmount() {
        steps.getTotalAmount();
    }

    @Then("^The total amount has at least (.*) digits")
    public void verifyNumberOfDigits(int numberOfDigits) {
        steps.numberHasAtLeastTwoDigits(numberOfDigits);
    }


    @Then("^The amount is equal to the sum of all credits")
    public void verifyAmount() {
        steps.compareAmountWithCredits();
    }
    
    @When("^I get the transaction date")
    public void getTransactionDate() throws JAXBException {
        steps.compareDate();
    }
    
    @Then("The transaction date is not in the future")
    public void verifyTransactionDate() throws JAXBException { steps.compareDate(); }

    @When("^I retrieve the IBAN")
    public void getIban() {
        steps.getIban();
    }
    
    @Then("^The IBAN is valid")
    public void validateIban() {
        steps.validateIbans();
    }




}
