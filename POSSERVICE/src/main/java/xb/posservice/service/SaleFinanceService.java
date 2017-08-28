package xb.posservice.service;



import java.util.List;

import xb.posservice.dao.vo.SaleFinanceInfo;

import xb.posservice.dao.vo.RepayInfo;

public interface SaleFinanceService {

	Long addSaleFinanceInfo(SaleFinanceInfo saleFinance);
	
	List<SaleFinanceInfo> getpaymentByKey(String sktNo, String jlbh);
	
	SaleFinanceInfo getSaleFinanceByref(String paymentId);
	
	List<SaleFinanceInfo> getSaleFinanceInfo(int hyId, int pageStart, int pageEnd);
	
	Long addRepayInfo(RepayInfo repayInfo);
	
	void updateRepayInfoStatus(RepayInfo repayInfo);
	
	RepayInfo getRepayInfoBychano(String channelSerialNo);
	
	List<RepayInfo> getRepayInfoBystatus(int status);
	
	void transRepayInfo();
}
