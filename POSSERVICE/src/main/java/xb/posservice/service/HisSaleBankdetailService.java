package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_BANKDETAIL;
import xb.posservice.dao.vo.HIS_SALE_BANKDETAILKey;
import xb.posservice.dao.vo.SALE_BANKDETAILKey;

public interface HisSaleBankdetailService {
	
	 int insert(HIS_SALE_BANKDETAIL record);
	 HIS_SALE_BANKDETAIL selectByPrimaryKey(HIS_SALE_BANKDETAILKey key);
	 List<HIS_SALE_BANKDETAIL> selectByskt(SALE_BANKDETAILKey key);
	 HIS_SALE_BANKDETAIL selectoneByskt(SALE_BANKDETAILKey key);
}
