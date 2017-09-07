package xb.posservice.dao.vo;

import java.math.BigDecimal;

public class SKTRB extends SKTRBKey {
    private String skfsname;

    private BigDecimal xsje;

    private Long xsbs;

    public String getSkfsname() {
        return skfsname;
    }

    public void setSkfsname(String skfsname) {
        this.skfsname = skfsname == null ? null : skfsname.trim();
    }

    public BigDecimal getXsje() {
        return xsje;
    }

    public void setXsje(BigDecimal xsje) {
        this.xsje = xsje;
    }

    public Long getXsbs() {
        return xsbs;
    }

    public void setXsbs(Long xsbs) {
        this.xsbs = xsbs;
    }
}