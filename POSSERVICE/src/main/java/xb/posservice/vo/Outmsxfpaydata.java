package xb.posservice.vo;

public class Outmsxfpaydata {

	private String code;
	private String message;
	private String sign;
	 private Outmsxfpaydata1 data;
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Outmsxfpaydata1 getData() {
		return data;
	}
	public void setData(Outmsxfpaydata1 data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
class Outmsxfpaydata1 {
	private String amount;
	private String realamount;
	private String message;
	private String status;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRealamount() {
		return realamount;
	}
	public void setRealamount(String realamount) {
		this.realamount = realamount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

