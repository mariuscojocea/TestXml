package stepLib;

import nl.garvelink.iban.IBAN;
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

public class Base {

    private XmlFileHandler xmlFileHandler;
    private Document document;

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
    protected static boolean validateIban(String iban) {
        IBAN ibn = IBAN.parse(iban);
        return ibn.isSEPA();
    }

    //validates xml file with xsd file
    protected boolean validateXml(String xmlFile, String xsdFile) {
        return XmlValidation.checkXml(xmlFile, xsdFile);
    }

}
