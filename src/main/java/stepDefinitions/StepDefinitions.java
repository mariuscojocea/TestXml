package stepDefinitions;

import extractor.CreditExtractor;
import extractor.IbanExtractor;
import extractor.TotalAmountExtractor;
import extractor.TransactionDateExtractor;
import org.joda.time.LocalDate;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.ArrayList;

import static utils.IBANValidationUtils.validateIban;

public class StepDefinitions extends Base{


    public String xmlFilePath(String file) {
        String path =  "src/main/resources/files/" + file + ".xml";
        return path;
    }

    public BigDecimal getTotalAmount() throws JAXBException {
        return new TotalAmountExtractor().getTotalAmount();
    }

    public boolean numberHasAtLeastTwoDigits(int digits) throws JAXBException {
        BigDecimal number = new TotalAmountExtractor().getTotalAmount();
        return number.toString().length() >= digits;
    }

    public BigDecimal getCredits() throws JAXBException {
        return new CreditExtractor().getCredits();
    }

    public void compareAmountWithCredits() throws JAXBException {
        getTotalAmount().equals(getCredits());
    }

    public void compareDate() throws JAXBException {
        LocalDate currentDate = LocalDate.now();
        new TransactionDateExtractor().getTransactionDate();
        currentDate.isAfter(new TransactionDateExtractor().getTransactionDate());
    }

    public ArrayList<String> getIban() throws JAXBException {
        return new IbanExtractor().getIban();
    }

    public void validateIbans() throws JAXBException {
        for (String iban : getIban()) {
            validateIban(iban);
        }
    }


}
