package xb.posservice.dao.vo;

public class TICK_CONDITION_DETAIL extends TICK_CONDITION_DETAILKey {
    private String configcontent;

    public String getConfigcontent() {
        return configcontent;
    }

    public void setConfigcontent(String configcontent) {
        this.configcontent = configcontent == null ? null : configcontent.trim();
    }
}