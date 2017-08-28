package xb.posservice.service;

import xb.posservice.dao.vo.HIS_SALE;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;

public interface HisSaleService {
	 HIS_SALE selectByPrimaryKey(SALEKey key);
	 HIS_SALE selectMaxJlbh(String sktno);
}
