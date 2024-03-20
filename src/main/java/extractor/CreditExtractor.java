package extractor;

import parser.CdtTrfTxInf;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.List;

public class CreditExtractor extends XmlExtractor{
    public BigDecimal getCredits() throws JAXBException {
        List<CdtTrfTxInf> creditTransfers = unmarshalFile().getCstmrCdtTrfInitn().getPmtInf().getCdtTrfTxInf();

        BigDecimal sum = BigDecimal.ZERO;
        for (CdtTrfTxInf creditTransfer : creditTransfers) {
            BigDecimal instdAmt = creditTransfer.getAmt().getInstdAmt();
            sum = sum.add(instdAmt);
        }
        return sum;
    }
}
