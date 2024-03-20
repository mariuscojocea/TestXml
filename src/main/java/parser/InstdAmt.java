package parser;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class InstdAmt extends Amt {

    @XmlValue
    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }
}
