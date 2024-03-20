package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CdtTrfTxInf extends PmtInf{
    @XmlElement(name = "Amt")
    private Amt amt;

    @XmlElement(name = "CdtrAcct")
    private CdtrAcct cdtrAcct;

    //amount
    public Amt getAmt() { return amt; }

    public CdtrAcct getCdtrAcct() { return cdtrAcct; }
}