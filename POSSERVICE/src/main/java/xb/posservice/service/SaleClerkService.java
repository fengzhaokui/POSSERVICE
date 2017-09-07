package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_CLERK;
import xb.posservice.dao.vo.SALE_CLERKKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_PAYMENTS;
import xb.posservice.dao.vo.SALE_PAYMENTSKey;

public interface SaleClerkService {
	SALE_CLERK selectByPrimaryKey(SALE_CLERKKey key);
	List<SALE_CLERK> selectByskt(SALE_CLERKKey key);
}
