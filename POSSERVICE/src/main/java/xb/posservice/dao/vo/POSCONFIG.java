package xb.posservice.dao.vo;

import java.util.Date;

public class POSCONFIG {
    private Long jlbh;

    private Long defVal;

    private Long curVal;

    private Long maxVal;

    private Long minVal;

    private String yy;

    private String name;

    private Long lastmodifierid;

    private String lastmodifiername;

    private Date lastmodifydate;

    public Long getJlbh() {
        return jlbh;
    }

    public void setJlbh(Long jlbh) {
        this.jlbh = jlbh;
    }

    public Long getDefVal() {
        return defVal;
    }

    public void setDefVal(Long defVal) {
        this.defVal = defVal;
    }

    public Long getCurVal() {
        return curVal;
    }

    public void setCurVal(Long curVal) {
        this.curVal = curVal;
    }

    public Long getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Long maxVal) {
        this.maxVal = maxVal;
    }

    public Long getMinVal() {
        return minVal;
    }

    public void setMinVal(Long minVal) {
        this.minVal = minVal;
    }

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy == null ? null : yy.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getLastmodifierid() {
        return lastmodifierid;
    }

    public void setLastmodifierid(Long lastmodifierid) {
        this.lastmodifierid = lastmodifierid;
    }

    public String getLastmodifiername() {
        return lastmodifiername;
    }

    public void setLastmodifiername(String lastmodifiername) {
        this.lastmodifiername = lastmodifiername == null ? null : lastmodifiername.trim();
    }

    public Date getLastmodifydate() {
        return lastmodifydate;
    }

    public void setLastmodifydate(Date lastmodifydate) {
        this.lastmodifydate = lastmodifydate;
    }
}