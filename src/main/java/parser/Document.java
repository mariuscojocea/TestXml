package parser;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
    @XmlElement(name = "CstmrCdtTrfInitn")
    private CstmrCdtTrfInitn cstmrCdtTrfInitn;

    public CstmrCdtTrfInitn getCstmrCdtTrfInitn() {
        return cstmrCdtTrfInitn;
    }
}
