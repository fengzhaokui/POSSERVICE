package xb.posservice.dao.vo;

public class SALE_CLERKKey {
    private String sktno;

    private Long jlbh;

    private Integer tcktInx;

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
}