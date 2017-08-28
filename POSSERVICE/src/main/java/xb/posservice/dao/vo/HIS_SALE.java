package xb.posservice.dao.vo;

import java.math.BigDecimal;
import java.util.Date;

public class HIS_SALE extends HIS_SALEKey {
    private Date jysj;

    private Date jzrq;

    private Long sky;

    private Long thfhr;

    private Integer viptype;

    private String glkkh;

    private BigDecimal zlje;

    private BigDecimal xsje;

    private Long vipid;

    private Long xfjlid;

    private String sktnoOld;

    private Long jlbhOld;

    private Double jf;

    private Double dkjf;

    private String sjhm;

    private String cardno;

    private Integer status;

    private Integer bjOffline;

    private Double syjf;

    private Integer backreason;

    private Long shopid;

    public Date getJysj() {
        return jysj;
    }

    public void setJysj(Date jysj) {
        this.jysj = jysj;
    }

    public Date getJzrq() {
        return jzrq;
    }

    public void setJzrq(Date jzrq) {
        this.jzrq = jzrq;
    }

    public Long getSky() {
        return sky;
    }

    public void setSky(Long sky) {
        this.sky = sky;
    }

    public Long getThfhr() {
        return thfhr;
    }

    public void setThfhr(Long thfhr) {
        this.thfhr = thfhr;
    }

    public Integer getViptype() {
        return viptype;
    }

    public void setViptype(Integer viptype) {
        this.viptype = viptype;
    }

    public String getGlkkh() {
        return glkkh;
    }

    public void setGlkkh(String glkkh) {
        this.glkkh = glkkh == null ? null : glkkh.trim();
    }

    public BigDecimal getZlje() {
        return zlje;
    }

    public void setZlje(BigDecimal zlje) {
        this.zlje = zlje;
    }

    public BigDecimal getXsje() {
        return xsje;
    }

    public void setXsje(BigDecimal xsje) {
        this.xsje = xsje;
    }

    public Long getVipid() {
        return vipid;
    }

    public void setVipid(Long vipid) {
        this.vipid = vipid;
    }

    public Long getXfjlid() {
        return xfjlid;
    }

    public void setXfjlid(Long xfjlid) {
        this.xfjlid = xfjlid;
    }

    public String getSktnoOld() {
        return sktnoOld;
    }

    public void setSktnoOld(String sktnoOld) {
        this.sktnoOld = sktnoOld == null ? null : sktnoOld.trim();
    }

    public Long getJlbhOld() {
        return jlbhOld;
    }

    public void setJlbhOld(Long jlbhOld) {
        this.jlbhOld = jlbhOld;
    }

    public Double getJf() {
        return jf;
    }

    public void setJf(Double jf) {
        this.jf = jf;
    }

    public Double getDkjf() {
        return dkjf;
    }

    public void setDkjf(Double dkjf) {
        this.dkjf = dkjf;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm == null ? null : sjhm.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBjOffline() {
        return bjOffline;
    }

    public void setBjOffline(Integer bjOffline) {
        this.bjOffline = bjOffline;
    }

    public Double getSyjf() {
        return syjf;
    }

    public void setSyjf(Double syjf) {
        this.syjf = syjf;
    }

    public Integer getBackreason() {
        return backreason;
    }

    public void setBackreason(Integer backreason) {
        this.backreason = backreason;
    }

    public Long getShopid() {
        return shopid;
    }

    public void setShopid(Long shopid) {
        this.shopid = shopid;
    }
}