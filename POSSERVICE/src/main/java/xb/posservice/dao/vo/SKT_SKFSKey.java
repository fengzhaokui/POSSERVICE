package xb.posservice.dao.vo;

public class SKT_SKFSKey {
    private String sktno;

    private Integer skfsid;

    public String getSktno() {
        return sktno;
    }

    public void setSktno(String sktno) {
        this.sktno = sktno == null ? null : sktno.trim();
    }

    public Integer getSkfsid() {
        return skfsid;
    }

    public void setSkfsid(Integer skfsid) {
        this.skfsid = skfsid;
    }
}