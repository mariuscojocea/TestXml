package stepLib;

import org.joda.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.fail;

public class Steps extends Base{


    public void loadXml(String file) {
        loadXmlFile(file);
    }

    public void getTotalAmount() {
        getCtrlSum();
    }

    public void validateNumberDigits(int digits) {
        BigDecimal number = getCtrlSum();
        if(number.toString().length() < digits) {
            fail("The number has less than " + digits + " digits");
        }
    }

    public void compareAmountWithCredits() {
        System.out.println("Sum of all credits: " + getCredits());
        if(!getCtrlSum().equals(getCredits())) {
            fail("The total amount is not equal to the sum of the credits");
        }
    }

    public void compareDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate transactionDate = getTransactionDate();
        System.out.println("Transaction date: " + transactionDate);
        if (!currentDate.isAfter(transactionDate)) {
            fail("The transaction date is in the future");
        }
    }

    public ArrayList<String> getIbans() {
        ArrayList<String> allIbans = new ArrayList<String>();
        allIbans.add(getDebitorIban());
        allIbans.addAll(getCreditorIbans());
        System.out.println(allIbans);
        return allIbans;
    }

    public void validateIbans() {
        for (String iban : getIbans()) {
            validateIban(iban);
        }
    }

    public void verifyXmlValidation(String xmlFile, String xsdFile) {
        validateXml(xmlFile, xsdFile);
    }


}
