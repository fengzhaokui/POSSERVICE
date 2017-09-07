package xb.posservice.dao.vo;

public class HIS_SALE_PAYMENTSKey {
    private String sktno;

    private Long jlbh;

    private Integer skfs;

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

    public Integer getSkfs() {
        return skfs;
    }

    public void setSkfs(Integer skfs) {
        this.skfs = skfs;
    }
}