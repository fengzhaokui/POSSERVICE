package xb.posservice.dao.vo;

public class SHOPDEF {
    private Integer id;

    private String code;

    private String name;

    private Integer mallid;

    private Long floorid;

    private String jdecode;

    private String oldMdid;

    private Long tm;

    private Integer nosaleflag;

    private byte[] thirdkey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMallid() {
        return mallid;
    }

    public void setMallid(Integer mallid) {
        this.mallid = mallid;
    }

    public Long getFloorid() {
        return floorid;
    }

    public void setFloorid(Long floorid) {
        this.floorid = floorid;
    }

    public String getJdecode() {
        return jdecode;
    }

    public void setJdecode(String jdecode) {
        this.jdecode = jdecode == null ? null : jdecode.trim();
    }

    public String getOldMdid() {
        return oldMdid;
    }

    public void setOldMdid(String oldMdid) {
        this.oldMdid = oldMdid == null ? null : oldMdid.trim();
    }

    public Long getTm() {
        return tm;
    }

    public void setTm(Long tm) {
        this.tm = tm;
    }

    public Integer getNosaleflag() {
        return nosaleflag;
    }

    public void setNosaleflag(Integer nosaleflag) {
        this.nosaleflag = nosaleflag;
    }

    public byte[] getThirdkey() {
        return thirdkey;
    }

    public void setThirdkey(byte[] thirdkey) {
        this.thirdkey = thirdkey;
    }
}