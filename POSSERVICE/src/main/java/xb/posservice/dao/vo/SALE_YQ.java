package xb.posservice.dao.vo;

import java.math.BigDecimal;

public class SALE_YQ extends SALE_YQKey {
    private Long hyid;

    private Long yhqid;

    private String couponcode;

    private BigDecimal money;

    private BigDecimal coupbalance;

    private String coupname;

    public Long getHyid() {
        return hyid;
    }

    public void setHyid(Long hyid) {
        this.hyid = hyid;
    }

    public Long getYhqid() {
        return yhqid;
    }

    public void setYhqid(Long yhqid) {
        this.yhqid = yhqid;
    }

    public String getCouponcode() {
        return couponcode;
    }

    public void setCouponcode(String couponcode) {
        this.couponcode = couponcode == null ? null : couponcode.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getCoupbalance() {
        return coupbalance;
    }

    public void setCoupbalance(BigDecimal coupbalance) {
        this.coupbalance = coupbalance;
    }

    public String getCoupname() {
        return coupname;
    }

    public void setCoupname(String coupname) {
        this.coupname = coupname == null ? null : coupname.trim();
    }
}