package xb.posservice.dao.vo;

public class SKFS {
    private Integer code;

    private String name;

    private String kmCode;

    private Integer mark;

    private Integer type;

    private Double sxfbl;

    private Integer yhqid;

    private Integer yhqqybj;

    private Integer zlclfs;

    private Integer xssx;

    private Integer bjJf;

    private Integer status;

    private Integer bjFq;

    private Integer bjMj;

    private Integer bjUsed;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKmCode() {
        return kmCode;
    }

    public void setKmCode(String kmCode) {
        this.kmCode = kmCode == null ? null : kmCode.trim();
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getSxfbl() {
        return sxfbl;
    }

    public void setSxfbl(Double sxfbl) {
        this.sxfbl = sxfbl;
    }

    public Integer getYhqid() {
        return yhqid;
    }

    public void setYhqid(Integer yhqid) {
        this.yhqid = yhqid;
    }

    public Integer getYhqqybj() {
        return yhqqybj;
    }

    public void setYhqqybj(Integer yhqqybj) {
        this.yhqqybj = yhqqybj;
    }

    public Integer getZlclfs() {
        return zlclfs;
    }

    public void setZlclfs(Integer zlclfs) {
        this.zlclfs = zlclfs;
    }

    public Integer getXssx() {
        return xssx;
    }

    public void setXssx(Integer xssx) {
        this.xssx = xssx;
    }

    public Integer getBjJf() {
        return bjJf;
    }

    public void setBjJf(Integer bjJf) {
        this.bjJf = bjJf;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBjFq() {
        return bjFq;
    }

    public void setBjFq(Integer bjFq) {
        this.bjFq = bjFq;
    }

    public Integer getBjMj() {
        return bjMj;
    }

    public void setBjMj(Integer bjMj) {
        this.bjMj = bjMj;
    }

    public Integer getBjUsed() {
        return bjUsed;
    }

    public void setBjUsed(Integer bjUsed) {
        this.bjUsed = bjUsed;
    }
}