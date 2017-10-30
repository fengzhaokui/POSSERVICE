package xb.posservice.dao.vo;

public class TICK_BASIC extends TICK_BASICKey {
    private Integer paperwidth;

    private Integer topmargin;

    private Integer bottommargin;

    private Integer leftmargin;

    private Integer rightmargin;

    private Integer rowspace;

    private String lineformat;

    private String dateformat;

    private String timeformat;

    private String website;

    private String hotline;

    private Integer alignment;

    private Integer cutway;

    private String lineformatAgain;

    public Integer getPaperwidth() {
        return paperwidth;
    }

    public void setPaperwidth(Integer paperwidth) {
        this.paperwidth = paperwidth;
    }

    public Integer getTopmargin() {
        return topmargin;
    }

    public void setTopmargin(Integer topmargin) {
        this.topmargin = topmargin;
    }

    public Integer getBottommargin() {
        return bottommargin;
    }

    public void setBottommargin(Integer bottommargin) {
        this.bottommargin = bottommargin;
    }

    public Integer getLeftmargin() {
        return leftmargin;
    }

    public void setLeftmargin(Integer leftmargin) {
        this.leftmargin = leftmargin;
    }

    public Integer getRightmargin() {
        return rightmargin;
    }

    public void setRightmargin(Integer rightmargin) {
        this.rightmargin = rightmargin;
    }

    public Integer getRowspace() {
        return rowspace;
    }

    public void setRowspace(Integer rowspace) {
        this.rowspace = rowspace;
    }

    public String getLineformat() {
        return lineformat;
    }

    public void setLineformat(String lineformat) {
        this.lineformat = lineformat == null ? null : lineformat.trim();
    }

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat == null ? null : dateformat.trim();
    }

    public String getTimeformat() {
        return timeformat;
    }

    public void setTimeformat(String timeformat) {
        this.timeformat = timeformat == null ? null : timeformat.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline == null ? null : hotline.trim();
    }

    public Integer getAlignment() {
        return alignment;
    }

    public void setAlignment(Integer alignment) {
        this.alignment = alignment;
    }

    public Integer getCutway() {
        return cutway;
    }

    public void setCutway(Integer cutway) {
        this.cutway = cutway;
    }

    public String getLineformatAgain() {
        return lineformatAgain;
    }

    public void setLineformatAgain(String lineformatAgain) {
        this.lineformatAgain = lineformatAgain == null ? null : lineformatAgain.trim();
    }
}