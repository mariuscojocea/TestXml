package extractor;


import parser.CdtTrfTxInf;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class IbanExtractor extends XmlExtractor {

    public ArrayList<String> getIban() throws JAXBException {
        ArrayList<String> allIbans = new ArrayList<String>();

        //get debitor IBAN
        String debitorAccIban =  unmarshalFile().getCstmrCdtTrfInitn().getPmtInf().getDbtrAcct().getId().getIban();
        allIbans.add(debitorAccIban);

        //get all creditors IBANS
        List<CdtTrfTxInf> creditorAccIbans = unmarshalFile().getCstmrCdtTrfInitn().getPmtInf().getCdtTrfTxInf();
        for (CdtTrfTxInf creditorAccIban : creditorAccIbans) {
            String iban = creditorAccIban.getCdtrAcct().getCreditorId().getIban();
            allIbans.add(iban);
        }
        return allIbans;
    }

}
