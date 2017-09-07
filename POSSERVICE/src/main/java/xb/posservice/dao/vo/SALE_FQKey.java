package xb.posservice.dao.vo;

public class SALE_FQKey {
    private String sktno;

    private Long jlbh;

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

    public Integer getInx() {
        return inx;
    }

    public void setInx(Integer inx) {
        this.inx = inx;
    }
}