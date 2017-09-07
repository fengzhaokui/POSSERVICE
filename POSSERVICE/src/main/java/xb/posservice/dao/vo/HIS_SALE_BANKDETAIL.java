package xb.posservice.dao.vo;

import java.math.BigDecimal;

public class HIS_SALE_BANKDETAIL extends HIS_SALE_BANKDETAILKey {
    private Integer jylx;

    private String cardno;

    private String pch;

    private String ckh;

    private String lsh;

    private BigDecimal je;

    private BigDecimal zkje;

    private Integer skfsid;

    public Integer getJylx() {
        return jylx;
    }

    public void setJylx(Integer jylx) {
        this.jylx = jylx;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getPch() {
        return pch;
    }

    public void setPch(String pch) {
        this.pch = pch == null ? null : pch.trim();
    }

    public String getCkh() {
        return ckh;
    }

    public void setCkh(String ckh) {
        this.ckh = ckh == null ? null : ckh.trim();
    }

    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh == null ? null : lsh.trim();
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public BigDecimal getZkje() {
        return zkje;
    }

    public void setZkje(BigDecimal zkje) {
        this.zkje = zkje;
    }

    public Integer getSkfsid() {
        return skfsid;
    }

    public void setSkfsid(Integer skfsid) {
        this.skfsid = skfsid;
    }
}