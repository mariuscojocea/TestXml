package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DebitorId extends DbtrAcct{
    @XmlElement(name = "IBAN")
    public String iban;

    public String getIban() { return iban; }

}
