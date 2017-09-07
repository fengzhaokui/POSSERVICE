package xb.posservice.dao.vo;

public class SALEKey {
    private String sktno;

    private Long jlbh;
    
    private Integer status;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}