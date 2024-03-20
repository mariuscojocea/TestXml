package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CstmrCdtTrfInitn extends Document{
    @XmlElement(name = "GrpHdr")
    private GrpHdr grpHdr;

    @XmlElement(name = "PmtInf")
    private PmtInf pmtInf;

    public GrpHdr getGrpHdr() {
        return grpHdr;
    }

    public PmtInf getPmtInf() {
        return pmtInf;
    }

}
