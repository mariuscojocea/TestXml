package extractor;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;

public class TotalAmountExtractor extends XmlExtractor{
    public BigDecimal getTotalAmount() throws JAXBException {
        return unmarshalFile().getCstmrCdtTrfInitn().getGrpHdr().getCtrlSum();
    }
}
