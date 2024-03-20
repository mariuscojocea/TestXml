package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class GrpHdr extends Document{
    @XmlElement(name = "CtrlSum")
    private BigDecimal ctrlSum;

    @XmlElement(name = "CreDtTm")
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
