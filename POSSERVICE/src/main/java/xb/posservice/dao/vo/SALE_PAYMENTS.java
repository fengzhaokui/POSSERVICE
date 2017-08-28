package xb.posservice.dao.vo;

import java.math.BigDecimal;

public class SALE_PAYMENTS extends SALE_PAYMENTSKey {
    private BigDecimal skje;

    private BigDecimal yyje;

    public BigDecimal getSkje() {
        return skje;
    }

    public void setSkje(BigDecimal skje) {
        this.skje = skje;
    }

    public BigDecimal getYyje() {
        return yyje;
    }

    public void setYyje(BigDecimal yyje) {
        this.yyje = yyje;
    }
}