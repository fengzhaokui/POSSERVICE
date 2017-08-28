package xb.posservice.service;

import xb.posservice.dao.vo.SALE_BANKDETAIL;
import xb.posservice.dao.vo.SALE_BANKDETAILKey;
import xb.posservice.dao.vo.TOKEN;

public interface SaleBankdetailService {
	
	 int insert(SALE_BANKDETAIL record);
	 SALE_BANKDETAIL selectByPrimaryKey(SALE_BANKDETAILKey key);
	 SALE_BANKDETAIL selectByskt(SALE_BANKDETAILKey key);
}
