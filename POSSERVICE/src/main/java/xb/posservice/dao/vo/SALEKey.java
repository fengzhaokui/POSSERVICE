package xb.posservice.dao.vo;

import java.util.List;

public class SALEKey {
    private String sktno;

    private Long jlbh;
    
    private Integer status;
    private List<Integer> statuslist;
    private Long thfhr;
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

	public List<Integer> getStatuslist() {
		return statuslist;
	}

	public void setStatuslist(List<Integer> statuslist) {
		this.statuslist = statuslist;
	}

	public Long getThfhr() {
		return thfhr;
	}

	public void setThfhr(Long thfhr) {
		this.thfhr = thfhr;
	}
}