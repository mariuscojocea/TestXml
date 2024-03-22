package stepLib;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import parser.CdtTrfTxInf;
import parser.Document;
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

    public static ArrayList<String> invalidIbans = new ArrayList<>();


    //loads provided XML file in feature file
    protected void loadXmlFile(String file) {
        xmlFileHandler = XmlFileHandlerFactory.createXmlFileHandler(file);
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

    //validates iban format
    //dropped it because it gives a IllegalArgumentException when parsing an invalid IBAN but the report is not clear
//    protected static boolean validateIban(String iban) {
//        IBAN ibn = IBAN.parse(iban);
//        return ibn.isSEPA();
//    }

    protected void validateIban(String iban) {
        String ibanPattern = "^[A-Z]{2}[0-9]{2}[A-Z0-9]{4}[0-9]{7}([A-Z0-9]?){0,16}$";
        Pattern pattern = Pattern.compile(ibanPattern);
        Matcher matcher = pattern.matcher(iban);
        if (!matcher.matches()) {
            invalidIbans.add(iban);
        }
    }

    //validates xml file with xsd file
    protected boolean validateXml(String xmlFile, String xsdFile) {
        return XmlValidation.checkXml(xmlFile, xsdFile);
    }

}
