package parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DbtrAcct extends PmtInf{
    @XmlElement(name = "Id")
    private DebitorId debitorId;

    public DebitorId getId() { return debitorId; }
}
