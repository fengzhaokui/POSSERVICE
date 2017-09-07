package xb.posservice.dao.vo;

public class MEM_TYPEDEF {
    private Long hyktype;

    private String typename;

    private Integer flagCashcard;

    private Integer flagVoucher;

    private Integer flagCent;

    private String erpcode;

    public Long getHyktype() {
        return hyktype;
    }

    public void setHyktype(Long hyktype) {
        this.hyktype = hyktype;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getFlagCashcard() {
        return flagCashcard;
    }

    public void setFlagCashcard(Integer flagCashcard) {
        this.flagCashcard = flagCashcard;
    }

    public Integer getFlagVoucher() {
        return flagVoucher;
    }

    public void setFlagVoucher(Integer flagVoucher) {
        this.flagVoucher = flagVoucher;
    }

    public Integer getFlagCent() {
        return flagCent;
    }

    public void setFlagCent(Integer flagCent) {
        this.flagCent = flagCent;
    }

    public String getErpcode() {
        return erpcode;
    }

    public void setErpcode(String erpcode) {
        this.erpcode = erpcode == null ? null : erpcode.trim();
    }
}