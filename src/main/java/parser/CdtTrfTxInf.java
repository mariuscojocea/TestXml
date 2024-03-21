package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CdtTrfTxInf {
    @XmlElement(name = "Amt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private Amt amt;

    @XmlElement(name = "CdtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private CdtrAcct cdtrAcct;

    //amount
    public Amt getAmt() { return amt; }

    public CdtrAcct getCdtrAcct() { return cdtrAcct; }
}