package extractor;


import org.joda.time.LocalDate;

import javax.xml.bind.JAXBException;

public class TransactionDateExtractor extends XmlExtractor{
    public LocalDate getTransactionDate() throws JAXBException {
        return unmarshalFile().getCstmrCdtTrfInitn().getPmtInf().getReqdExctnDt();
    }
}
