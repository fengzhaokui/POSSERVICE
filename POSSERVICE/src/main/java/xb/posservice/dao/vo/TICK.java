package xb.posservice.dao.vo;

import java.util.Date;

public class TICK {
    private Integer id;

    private String name;

    private Integer ticktype;

    private Integer status;

    private String djrmc;

    private Date djsj;

    private Long djr;

    private Long qdr;

    private String qdrmc;

    private Date qdsj;

    private Long zzr;

    private String zzrmc;

    private Date zzsj;

    private Integer mallid;

    private Integer dyfa;

    private Integer dycs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTicktype() {
        return ticktype;
    }

    public void setTicktype(Integer ticktype) {
        this.ticktype = ticktype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDjrmc() {
        return djrmc;
    }

    public void setDjrmc(String djrmc) {
        this.djrmc = djrmc == null ? null : djrmc.trim();
    }

    public Date getDjsj() {
        return djsj;
    }

    public void setDjsj(Date djsj) {
        this.djsj = djsj;
    }

    public Long getDjr() {
        return djr;
    }

    public void setDjr(Long djr) {
        this.djr = djr;
    }

    public Long getQdr() {
        return qdr;
    }

    public void setQdr(Long qdr) {
        this.qdr = qdr;
    }

    public String getQdrmc() {
        return qdrmc;
    }

    public void setQdrmc(String qdrmc) {
        this.qdrmc = qdrmc == null ? null : qdrmc.trim();
    }

    public Date getQdsj() {
        return qdsj;
    }

    public void setQdsj(Date qdsj) {
        this.qdsj = qdsj;
    }

    public Long getZzr() {
        return zzr;
    }

    public void setZzr(Long zzr) {
        this.zzr = zzr;
    }

    public String getZzrmc() {
        return zzrmc;
    }

    public void setZzrmc(String zzrmc) {
        this.zzrmc = zzrmc == null ? null : zzrmc.trim();
    }

    public Date getZzsj() {
        return zzsj;
    }

    public void setZzsj(Date zzsj) {
        this.zzsj = zzsj;
    }

    public Integer getMallid() {
        return mallid;
    }

    public void setMallid(Integer mallid) {
        this.mallid = mallid;
    }

    public Integer getDyfa() {
        return dyfa;
    }

    public void setDyfa(Integer dyfa) {
        this.dyfa = dyfa;
    }

    public Integer getDycs() {
        return dycs;
    }

    public void setDycs(Integer dycs) {
        this.dycs = dycs;
    }
}