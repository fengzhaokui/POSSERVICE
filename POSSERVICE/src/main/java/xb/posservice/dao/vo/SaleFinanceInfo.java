package xb.posservice.dao.vo;

import java.util.Date;

public class SaleFinanceInfo {

	
	public String getSktNo() {
		return sktNo;
	}
	public void setSktNo(String sktNo) {
		this.sktNo = sktNo;
	}
	public Integer getJlbh() {
		return jlbh;
	}
	public void setJlbh(Integer jlbh) {
		this.jlbh = jlbh;
	}
	public String getXsje() {
		return xsje;
	}
	public void setXsje(String xsje) {
		this.xsje = xsje;
	}
	public double getXfje() {
		return xfje;
	}
	public void setXfje(double xfje) {
		this.xfje = xfje;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public Date getJysj() {
		return jysj;
	}
	public void setJysj(Date jysj) {
		this.jysj = jysj;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getLeftAmt() {
		return leftAmt;
	}
	public void setLeftAmt(String leftAmt) {
		this.leftAmt = leftAmt;
	}
	public Integer getHyId() {
		return hyId;
	}
	public void setHyId(Integer hyId) {
		this.hyId = hyId;
	}
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getSpmx() {
		return spmx;
	}
	public void setSpmx(String spmx) {
		this.spmx = spmx;
	}
	
	public String getYdlsh() {
		return ydlsh;
	}
	public void setYdlsh(String ydlsh) {
		this.ydlsh = ydlsh;
	}

	String sktNo;//收款台号
	Integer jlbh;//小票号
	String xsje;//总金额
	double xfje;//消费金融金额
	String paymentId;//马上流水码
	Date jysj;//交易日期
	String totalAmt;//
	String leftAmt;//
	Integer hyId;//会员id
	String lsh;//交易流水号
	String ydlsh;//原单流水号只有退货单有
	String spmx;//明细
}
