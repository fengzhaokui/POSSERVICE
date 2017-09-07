package xb.posservice.dao.vo;

public class HIS_SALE_DETAILKey {
    private String sktno;

    private Long jlbh;

    private Integer tcktInx;

    private Integer inx;

    public String getSktno() {
        return sktno;
    }

    public void setSktno(String sktno) {
        this.sktno = sktno == null ? null : sktno.trim();
    }

    public Long getJlbh() {
        return jlbh;
    }

    public void setJlbh(Long jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getTcktInx() {
        return tcktInx;
    }

    public void setTcktInx(Integer tcktInx) {
        this.tcktInx = tcktInx;
    }

    public Integer getInx() {
        return inx;
    }

    public void setInx(Integer inx) {
        this.inx = inx;
    }
}