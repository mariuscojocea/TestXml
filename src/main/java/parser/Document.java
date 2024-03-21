package parser;
import javax.xml.bind.annotation.*;

//@XmlRootElement(name = "Document")
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
    @XmlElement(name = "CstmrCdtTrfInitn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private CstmrCdtTrfInitn cstmrCdtTrfInitn;

    public CstmrCdtTrfInitn getCstmrCdtTrfInitn() {
        return cstmrCdtTrfInitn;
    }
}
