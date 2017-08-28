package xb.posservice.dao.vo;

public class PERSONINFO {
    private Long personId;

    private String personName;

    private String rydm;

    private Long deptid;

    private Integer workType;

    private Integer status;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getRydm() {
        return rydm;
    }

    public void setRydm(String rydm) {
        this.rydm = rydm == null ? null : rydm.trim();
    }

    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}