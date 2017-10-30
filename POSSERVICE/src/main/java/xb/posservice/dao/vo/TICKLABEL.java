package xb.posservice.dao.vo;

public class TICKLABEL {
    private Integer id;

    private String name;

    private Integer conditionid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getConditionid() {
        return conditionid;
    }

    public void setConditionid(Integer conditionid) {
        this.conditionid = conditionid;
    }
}