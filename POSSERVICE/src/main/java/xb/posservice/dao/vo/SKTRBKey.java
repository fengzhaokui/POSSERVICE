package xb.posservice.dao.vo;

import java.util.Date;

public class SKTRBKey {
    private String sktno;

    private Date rq;

    private Integer lx;

    private Long skfsid;

    public String getSktno() {
        return sktno;
    }

    public void setSktno(String sktno) {
        this.sktno = sktno == null ? null : sktno.trim();
    }

    public Date getRq() {
        return rq;
    }

    public void setRq(Date rq) {
        this.rq = rq;
    }

    public Integer getLx() {
        return lx;
    }

    public void setLx(Integer lx) {
        this.lx = lx;
    }

    public Long getSkfsid() {
        return skfsid;
    }

    public void setSkfsid(Long skfsid) {
        this.skfsid = skfsid;
    }
}