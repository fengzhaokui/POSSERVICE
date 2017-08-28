package xb.posservice.vo;

import java.util.ArrayList;
import java.util.List;

import xb.posservice.vo.*;
import xb.posservice.vo.LoginPersonInfo;

public class OutLoginInfo {
	private String posno;
	private String billid;
	private String person_id;
	private String person_name;
	private String personcode;
	private String personxtm;
	private String jktype;
	private String token;
	public int ismallpos;
	public String thirdpayuser;
	public String thirdpaypwd;
	public String mac1;
	public String mac2;
	
	public OutShopInfo shopmsg = new OutShopInfo();
	public OutShopInfo mallmsg = new OutShopInfo();
	public List<LoginPersonInfo> loginpresonlist = new ArrayList<LoginPersonInfo>();
	public List<OutPosConfigInfo> configinfolist = new ArrayList<OutPosConfigInfo>();

	public String getPosno() {
		return posno;
	}

	public void setPosno(String posno) {
		this.posno = posno;
	}

	public String getBillid() {
		return billid;
	}

	public void setBillid(String billid) {
		this.billid = billid;
	}

	

	public String getPersoncode() {
		return personcode;
	}

	public void setPersoncode(String personcode) {
		this.personcode = personcode;
	}

	public String getPersonxtm() {
		return personxtm;
	}

	public void setPersonxtm(String personxtm) {
		this.personxtm = personxtm;
	}

	public String getJktype() {
		return jktype;
	}

	public void setJktype(String jktype) {
		this.jktype = jktype;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

}
