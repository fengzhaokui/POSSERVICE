package xb.posservice.dao.vo;

public class RepayInfo {
	
	public double amount;
	public String channelSierialNo;
	public String quickRepayNo;
	public String msUserId;
	public String sieralno;
	public Integer status;
	
	
	public String getChannelSierialNo() {
		return channelSierialNo;
	}
	public void setChannelSierialNo(String channelSierialNo) {
		this.channelSierialNo = channelSierialNo;
	}
	public String getSieralno() {
		return sieralno;
	}
	public void setSieralno(String sieralno) {
		this.sieralno = sieralno;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getQuickRepayNo() {
		return quickRepayNo;
	}
	public void setQuickRepayNo(String quickRepayNo) {
		this.quickRepayNo = quickRepayNo;
	}
	public String getMsUserId() {
		return msUserId;
	}
	public void setMsUserId(String msUserId) {
		this.msUserId = msUserId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
