package xb.posservice.dao.vo;

import java.math.BigDecimal;

public class SALE_DETAIL extends SALE_DETAILKey {
    private Long deptid;

    private Long spId;

    private String barcode;

    private BigDecimal lsdj;

    private BigDecimal xssl;

    private BigDecimal xsje;

    private BigDecimal zkje;

    private BigDecimal yhje;

    private BigDecimal point;

    private BigDecimal grantpoint;

    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public BigDecimal getLsdj() {
        return lsdj;
    }

    public void setLsdj(BigDecimal lsdj) {
        this.lsdj = lsdj;
    }

    public BigDecimal getXssl() {
        return xssl;
    }

    public void setXssl(BigDecimal xssl) {
        this.xssl = xssl;
    }

    public BigDecimal getXsje() {
        return xsje;
    }

    public void setXsje(BigDecimal xsje) {
        this.xsje = xsje;
    }

    public BigDecimal getZkje() {
        return zkje;
    }

    public void setZkje(BigDecimal zkje) {
        this.zkje = zkje;
    }

    public BigDecimal getYhje() {
        return yhje;
    }

    public void setYhje(BigDecimal yhje) {
        this.yhje = yhje;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public BigDecimal getGrantpoint() {
        return grantpoint;
    }

    public void setGrantpoint(BigDecimal grantpoint) {
        this.grantpoint = grantpoint;
    }
}