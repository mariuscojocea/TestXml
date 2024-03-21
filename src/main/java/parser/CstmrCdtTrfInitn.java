package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CstmrCdtTrfInitn {
    @XmlElement(name = "GrpHdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private GrpHdr grpHdr;

    @XmlElement(name = "PmtInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private PmtInf pmtInf;

    public GrpHdr getGrpHdr() {
        return grpHdr;
    }

    public PmtInf getPmtInf() {
        return pmtInf;
    }

}
