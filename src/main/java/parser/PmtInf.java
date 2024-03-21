package parser;

import org.joda.time.LocalDate;
import utils.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class PmtInf {
    @XmlElement(name = "CdtTrfTxInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private List<CdtTrfTxInf> cdtTrfTxInf;

    @XmlElement(name = "CtrlSum", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private String ctrlSum;

    @XmlElement(name = "ReqdExctnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate reqdExctnDt;

    @XmlElement(name = "DbtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    private DbtrAcct dbtrAcct;

    //credit
    public List<CdtTrfTxInf> getCdtTrfTxInf() { return cdtTrfTxInf; }

    public String getCtrlSum() { return ctrlSum;}

    public LocalDate getReqdExctnDt() {return reqdExctnDt; }

    public DbtrAcct getDbtrAcct() { return dbtrAcct; }

}
