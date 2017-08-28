package xb.posservice.dao.vo;

import java.util.Date;


public class MemberInfo {
	
	
	public Integer getHyId() {
		return hyId;
	}
	public void setHyId(Integer hyId) {
		this.hyId = hyId;
	}
	
	public String getAgreementId() {
		return agreementId;
	}
	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}
	public String getMsUserId() {
		return msUserId;
	}
	public void setMsUserId(String msUserId) {
		this.msUserId = msUserId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getHyname() {
		return hyname;
	}
	public void setHyname(String hyname) {
		this.hyname = hyname;
	}
	public String getYhkh() {
		return yhkh;
	}
	public void setYhkh(String yhkh) {
		this.yhkh = yhkh;
	}
	public String getSjhm() {
		return sjhm;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getCardProvinceCode() {
		return cardProvinceCode;
	}
	public void setCardProvinceCode(String cardProvinceCode) {
		this.cardProvinceCode = cardProvinceCode;
	}
	public String getCardCityCode() {
		return cardCityCode;
	}
	public void setCardCityCode(String cardCityCode) {
		this.cardCityCode = cardCityCode;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractPhone() {
		return contractPhone;
	}
	public void setContractPhone(String contractPhone) {
		this.contractPhone = contractPhone;
	}

	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getRecomendPhone() {
		return recomendPhone;
	}
	public void setRecomendPhone(String recomendPhone) {
		this.recomendPhone = recomendPhone;
	}


	public String getStatus_sp() {
		return status_sp;
	}
	public void setStatus_sp(String status_sp) {
		this.status_sp = status_sp;
	}

	public Integer getSendCouponStatus() {
		return sendCouponStatus;
	}
	public void setSendCouponStatus(Integer sendCouponStatus) {
		this.sendCouponStatus = sendCouponStatus;
	}


	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	private Integer hyId;
	private Integer sendCouponStatus;
	private String applyId;
	private String agreementId;
	private String msUserId;
	private String openId;
	private String sfzhm;
	private String hyname;
	private String yhkh;
	private String sjhm;
	private String password;
	private String region;
	private String cardProvinceCode;
	private String cardCityCode;
	private String contractName;
	private String contractPhone;
	private String provinceCode;
	private String provinceName;
	private String cityCode;
	private String cityName;
	private String zoneCode;
	private String zoneName;
	private String recomendPhone;
	private String status_sp;
	private Date createtime;
}
