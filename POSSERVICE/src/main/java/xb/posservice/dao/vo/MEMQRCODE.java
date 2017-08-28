package xb.posservice.dao.vo;

import java.util.Date;

public class MEMQRCODE extends MEMQRCODEKey {
    private String qrcode;

    private Integer errortimes;

    private Date lasttime;

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public Integer getErrortimes() {
        return errortimes;
    }

    public void setErrortimes(Integer errortimes) {
        this.errortimes = errortimes;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }
}