package xb.posservice.dao.vo;

import java.math.BigDecimal;

public class HIS_SALE_THIRDPAY extends HIS_SALE_THIRDPAYKey {
    private Integer jylx;

    private Integer channel;

    private String account;

    private String tradeno;

    private String outtradeno;

    private BigDecimal amount;

    private BigDecimal couponfee;

    private Integer skfsid;

    public Integer getJylx() {
        return jylx;
    }

    public void setJylx(Integer jylx) {
        this.jylx = jylx;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno == null ? null : tradeno.trim();
    }

    public String getOuttradeno() {
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
        this.outtradeno = outtradeno == null ? null : outtradeno.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCouponfee() {
        return couponfee;
    }

    public void setCouponfee(BigDecimal couponfee) {
        this.couponfee = couponfee;
    }

    public Integer getSkfsid() {
        return skfsid;
    }

    public void setSkfsid(Integer skfsid) {
        this.skfsid = skfsid;
    }
}