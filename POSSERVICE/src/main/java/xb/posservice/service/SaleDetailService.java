package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;

public interface SaleDetailService {
	SALE_DETAIL selectByPrimaryKey(SALE_DETAILKey key);
	List<SALE_DETAIL> selectByskt(SALE_DETAILKey key);
}
