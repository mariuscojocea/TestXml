package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;
import stepDefinitions.StepDefinitions;

import javax.xml.bind.JAXBException;

public class Steps{

    @Shared
    StepDefinitions stepDefinitions;

    @Given("^I have (.*) XML file")
    public void getFile(String file) {
        stepDefinitions.xmlFilePath(file);
    }

    @And("^The XML file is valid")
    public void validateXml() {
        //Add in a @Before
    }

    @When("^I verify the debtor total amount")
    public void verifyTotalAmount() throws JAXBException {
        stepDefinitions.getTotalAmount();
    }

    @Then("^The total amount has at least (.*) digits")
    public boolean verifyNumberOfDigits(int numberOfDigits) throws JAXBException {
        return stepDefinitions.numberHasAtLeastTwoDigits(numberOfDigits);
    }


    @Then("^The amount is equal to the sum of all credits")
    public void verifyAmount() throws JAXBException {
        stepDefinitions.compareAmountWithCredits();
    }
    
    @When("^I get the transaction date")
    public void getTransactionDate() throws JAXBException {
        stepDefinitions.compareDate();
    }
    
    @Then("The transaction date is not in the future")
    public void verifyTransactionDate() {}

    @When("^I retrieve the IBAN")
    public void getIban() throws JAXBException {
        stepDefinitions.getIban();
    }
    
    @Then("^The IBAN is valid")
    public void validateIban() throws JAXBException {
        stepDefinitions.validateIbans();
    }




}
