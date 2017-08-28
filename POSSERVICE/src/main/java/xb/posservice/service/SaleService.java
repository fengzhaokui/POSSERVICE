package xb.posservice.service;

import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;

public interface SaleService {
	 SALE selectByPrimaryKey(SALEKey key);
	 SALE selectMaxJlbh(String sktno);
}
