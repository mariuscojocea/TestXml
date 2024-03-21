package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DebitorId {
    @XmlElement(name = "IBAN", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    public String iban;

    public String getIban() { return iban; }

}
