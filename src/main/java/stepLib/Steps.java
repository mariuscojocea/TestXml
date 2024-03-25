package stepLib;

import junit.framework.TestCase;
import org.joda.time.LocalDate;
import utils.DateUtils;

import java.math.BigDecimal;

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
        if (new DateUtils().isDateInThePast(currentDate, transactionDate)) {
            fail("The transaction date is in the future: " + transactionDate);
        }
    }

    public void validateIbans() {
        if(!getInvalidIbans().isEmpty()) {
            TestCase.fail("The following ibans are invalid: " + getInvalidIbans());
        }
    }

    public void verifyXmlValidation(String xmlFile, String xsdFile) throws Exception {
        validateXml(xmlFile, xsdFile);
    }


}
