package stepLib;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import xmlParser.CdtTrfTxInf;
import xmlParser.Document;
import xmlFileHandler.DefaultXmlFileHandler;
import xmlFileHandler.XmlFileHandler;
import xmlFileHandler.XmlFileHandlerFactory;
import xmlValidation.XmlValidation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Base {

    private XmlFileHandler xmlFileHandler;
    private Document document;


    //loads provided XML file in feature file
    protected void loadXmlFile(String file) {
        xmlFileHandler = new XmlFileHandlerFactory().createXmlFileHandler(file);
        document = new DefaultXmlFileHandler(file).loadXmlFile(file);
    }

    //get debtor total amount
    protected BigDecimal getCtrlSum() {
        BigDecimal totalAmount = document.getCstmrCdtTrfInitn().getGrpHdr().getCtrlSum();
        System.out.println("Total amount: " + totalAmount);
        return totalAmount;
    }

    //get all credits
    protected List<CdtTrfTxInf> getAllCredits() {
        return document.getCstmrCdtTrfInitn().getPmtInf().getCdtTrfTxInf();
    }

    //sum of all credits
    protected BigDecimal getCredits() {
        List<CdtTrfTxInf> creditTransfers = getAllCredits();
        BigDecimal sum = BigDecimal.ZERO;
        for (CdtTrfTxInf creditTransfer : creditTransfers) {
            BigDecimal instdAmt = creditTransfer.getAmt().getInstdAmt();
            sum = sum.add(instdAmt);
        }
        return sum;
    }

    //get transaction date
    protected LocalDate getTransactionDate() {
        return document.getCstmrCdtTrfInitn().getPmtInf().getReqdExctnDt();
    }

    //get debitor iban
    protected String getDebitorIban() {
        String debitorAccIban =  document.getCstmrCdtTrfInitn().getPmtInf().getDbtrAcct().getId().getIban();
        return debitorAccIban;
    }

    //get all creditors ibans
    protected ArrayList<String> getCreditorIbans() {
        ArrayList<String> allICreditorsIbans = new ArrayList<String>();
        List<CdtTrfTxInf> allTransactionsInfo = document.getCstmrCdtTrfInitn().getPmtInf().getCdtTrfTxInf();
        for (CdtTrfTxInf creditorAccIban : allTransactionsInfo) {
            String iban = creditorAccIban.getCdtrAcct().getCreditorId().getIban();
            allICreditorsIbans.add(iban);
        }
        return allICreditorsIbans;
    }

    public ArrayList<String> getALlIbans() {
        ArrayList<String> allIbans = new ArrayList<>();
        allIbans.add(getDebitorIban());
        allIbans.addAll(getCreditorIbans());
        System.out.println(allIbans);
        return allIbans;
    }

    //validates ibans and adds them to a list of invalid ibans
    private boolean isIbanValid(String iban) {
        String ibanPattern = "^[A-Z]{2}[0-9]{2}[A-Z0-9]{4}[0-9]{7}([A-Z0-9]?){0,16}$";
        Pattern pattern = Pattern.compile(ibanPattern);
        Matcher matcher = pattern.matcher(iban);
        return matcher.matches();
    }

    //collects all invalid ibans
    protected ArrayList<String> getInvalidIbans() {
        ArrayList<String> invalidIbans = new ArrayList<>();
        for (String iban : getALlIbans()) {
            if(!isIbanValid(iban)) {
                invalidIbans.add(iban);
            }
        }
        return invalidIbans;
    }

    //validates xml file with xsd file
    protected void validateXml(String xmlFile, String xsdFile) throws Exception {
        new XmlValidation().checkXml(xmlFile, xsdFile);
    }

}
