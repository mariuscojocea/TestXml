package xmlParser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class GrpHdr {
    @XmlElement(name = "CtrlSum", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private BigDecimal ctrlSum;

    @XmlElement(name = "CreDtTm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private String creDtTm;

    //sum of all credits
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    //date
    public String getCreDtTm() {
        return creDtTm;
    }
}
