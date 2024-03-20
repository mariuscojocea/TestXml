package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class Amt extends CdtTrfTxInf{
    @XmlElement(name = "InstdAmt")
    private BigDecimal instdAmt;

    //credit amount
    public BigDecimal getInstdAmt() { return instdAmt; }
}
