package xb.posservice.dao.vo;

import java.math.BigDecimal;
import java.util.Date;

public class GOODS {
    private Long spId;

    private String name;

    private String nameQc;

    private String spfl;

    private Long sb;

    private String ghdw;

    private String sccj;

    private String spcode;

    private String barcode;

    private String hh;

    private String unit;

    private BigDecimal lsdj;

    private Integer sptype;

    private String bz;

    private Long djr;

    private String djrmc;

    private Date djrq;

    private Long gxr;

    private String gxrmc;

    private Date gxsj;

    private Integer status;

    private Double point;

    private String pic;

    private BigDecimal addmoney;

    private Integer shopid;

    private Integer bjCashbuy;

    private BigDecimal sqje;

    private Long tm;

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNameQc() {
        return nameQc;
    }

    public void setNameQc(String nameQc) {
        this.nameQc = nameQc == null ? null : nameQc.trim();
    }

    public String getSpfl() {
        return spfl;
    }

    public void setSpfl(String spfl) {
        this.spfl = spfl == null ? null : spfl.trim();
    }

    public Long getSb() {
        return sb;
    }

    public void setSb(Long sb) {
        this.sb = sb;
    }

    public String getGhdw() {
        return ghdw;
    }

    public void setGhdw(String ghdw) {
        this.ghdw = ghdw == null ? null : ghdw.trim();
    }

    public String getSccj() {
        return sccj;
    }

    public void setSccj(String sccj) {
        this.sccj = sccj == null ? null : sccj.trim();
    }

    public String getSpcode() {
        return spcode;
    }

    public void setSpcode(String spcode) {
        this.spcode = spcode == null ? null : spcode.trim();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getHh() {
        return hh;
    }

    public void setHh(String hh) {
        this.hh = hh == null ? null : hh.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getLsdj() {
        return lsdj;
    }

    public void setLsdj(BigDecimal lsdj) {
        this.lsdj = lsdj;
    }

    public Integer getSptype() {
        return sptype;
    }

    public void setSptype(Integer sptype) {
        this.sptype = sptype;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Long getDjr() {
        return djr;
    }

    public void setDjr(Long djr) {
        this.djr = djr;
    }

    public String getDjrmc() {
        return djrmc;
    }

    public void setDjrmc(String djrmc) {
        this.djrmc = djrmc == null ? null : djrmc.trim();
    }

    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    public Long getGxr() {
        return gxr;
    }

    public void setGxr(Long gxr) {
        this.gxr = gxr;
    }

    public String getGxrmc() {
        return gxrmc;
    }

    public void setGxrmc(String gxrmc) {
        this.gxrmc = gxrmc == null ? null : gxrmc.trim();
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public BigDecimal getAddmoney() {
        return addmoney;
    }

    public void setAddmoney(BigDecimal addmoney) {
        this.addmoney = addmoney;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getBjCashbuy() {
        return bjCashbuy;
    }

    public void setBjCashbuy(Integer bjCashbuy) {
        this.bjCashbuy = bjCashbuy;
    }

    public BigDecimal getSqje() {
        return sqje;
    }

    public void setSqje(BigDecimal sqje) {
        this.sqje = sqje;
    }

    public Long getTm() {
        return tm;
    }

    public void setTm(Long tm) {
        this.tm = tm;
    }
}