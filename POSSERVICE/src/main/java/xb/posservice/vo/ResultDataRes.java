package xb.posservice.vo;

public class ResultDataRes {
	private String retcode;
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
		this.retmsg="成功";
	}
	
	private String retmsg;
	
	
	private OUserCouponData data;
	public OUserCouponData getData() {
		return data;
	}
	public void setData(OUserCouponData data) {
		this.data = data;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	

}
