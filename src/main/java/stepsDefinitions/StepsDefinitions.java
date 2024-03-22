package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;
import stepLib.Steps;

public class StepsDefinitions {

    @Shared
    Steps steps;

    @Given("^I have (.*) XML file")
    public void getFile(String file) {
        steps.loadXml(file);
    }

    @Then("^The XML (.*) file is valid against (.*) schema")
    public void validateXmlFile(String xmlFile, String xsdFile) throws Exception {
        steps.verifyXmlValidation(xmlFile, xsdFile);
    }

    @When("^I verify the debtor total amount")
    public void verifyTotalAmount() {
        steps.getTotalAmount();
    }

    @Then("^The total amount has at least (.*) digits")
    public void verifyNumberOfDigits(int numberOfDigits) {
        steps.validateNumberDigits(numberOfDigits);
    }


    @Then("^The amount is equal to the sum of all credits")
    public void verifyAmount() {
        steps.compareAmountWithCredits();
    }
    
    @When("^I get the transaction date")
    public void getTransactionDate() {
        steps.compareDate();
    }
    
    @Then("The transaction date is not in the future")
    public void verifyTransactionDate() { steps.compareDate(); }

    @When("^I retrieve the IBAN")
    public void getIban() {
        steps.getIbans();
    }
    
    @Then("^The IBAN is valid")
    public void validateIban() {
        steps.validateIbans();
    }




}
