package xb.posservice.dao.vo;

import java.math.BigDecimal;

public class HIS_SALE_PAYMENTS extends HIS_SALE_PAYMENTSKey {
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