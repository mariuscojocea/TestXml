package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CdtrAcct extends CdtTrfTxInf{
    @XmlElement(name = "Id")
    private CreditorId creditorId;

    public CreditorId getCreditorId() { return creditorId; }

}
