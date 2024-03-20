package parser;

import org.joda.time.LocalDate;
import utils.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class PmtInf extends CstmrCdtTrfInitn{
    @XmlElement(name = "CdtTrfTxInf")
    private List<CdtTrfTxInf> cdtTrfTxInf;

    @XmlElement(name = "CtrlSum")
    private String ctrlSum;

    @XmlElement(name = "ReqdExctnDt")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate reqdExctnDt;

    @XmlElement(name = "DbtrAcct")
    private DbtrAcct dbtrAcct;

    //credit
    public List<CdtTrfTxInf> getCdtTrfTxInf() { return cdtTrfTxInf; }

    public String getCtrlSum() { return ctrlSum;}

    public LocalDate getReqdExctnDt() {return reqdExctnDt; }

    public DbtrAcct getDbtrAcct() { return dbtrAcct; }

}
