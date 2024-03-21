package stepLib;

import org.joda.time.LocalDate;
import parser.CdtTrfTxInf;
import parser.Document;
import xmlFileHandler.*;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static utils.IBANValidationUtils.validateIban;

public class Steps {

    private XmlFileHandler xmlFileHandler;
    private Document document;

    public void xmlFilePath(String file) throws JAXBException {
        xmlFileHandler = XmlFileHandlerFactory.createXmlFileHandler(file);
//        xmlFileHandler.loadXmlFile(file);
        document = new DefaultXmlFileHandler(file).loadXmlFile(file);
    }

    public BigDecimal getTotalAmount() {
        return document.getCstmrCdtTrfInitn().getGrpHdr().getCtrlSum();
    }

    public void numberHasAtLeastTwoDigits(int digits) {
        BigDecimal number = document.getCstmrCdtTrfInitn().getGrpHdr().getCtrlSum();
        if(number.toString().length() < digits) {
            fail("The number has less than " + digits + " digits");
        }
    }

    public BigDecimal getCredits() {
        List<CdtTrfTxInf> creditTransfers = document.getCstmrCdtTrfInitn().getPmtInf().getCdtTrfTxInf();
        BigDecimal sum = BigDecimal.ZERO;
        for (CdtTrfTxInf creditTransfer : creditTransfers) {
            BigDecimal instdAmt = creditTransfer.getAmt().getInstdAmt();
            sum = sum.add(instdAmt);
        }
        return sum;
    }

    public void compareAmountWithCredits() {
        if(!getTotalAmount().equals(getCredits())) {
            fail("The total amount is not equal to the sum of the credits");
        }
    }

    public void compareDate() throws JAXBException {
        LocalDate currentDate = LocalDate.now();
        LocalDate transactionDate = document.getCstmrCdtTrfInitn().getPmtInf().getReqdExctnDt();
        if (!currentDate.isAfter(transactionDate)) {
            fail("The transaction date is in the future");
        }
    }

    public ArrayList<String> getIban() {
        ArrayList<String> allIbans = new ArrayList<String>();

        //get debitor IBAN
        String debitorAccIban =  document.getCstmrCdtTrfInitn().getPmtInf().getDbtrAcct().getId().getIban();
        allIbans.add(debitorAccIban);

        //get all creditors IBANS
        List<CdtTrfTxInf> creditorAccIbans = document.getCstmrCdtTrfInitn().getPmtInf().getCdtTrfTxInf();
        for (CdtTrfTxInf creditorAccIban : creditorAccIbans) {
            String iban = creditorAccIban.getCdtrAcct().getCreditorId().getIban();
            allIbans.add(iban);
        }
        return allIbans;
    }

    public void validateIbans() {
        for (String iban : getIban()) {
            validateIban(iban);
        }
    }


}
