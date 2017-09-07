package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_PAYMENTS;
import xb.posservice.dao.vo.SALE_PAYMENTSKey;

public interface SalePaymentsService {
	SALE_PAYMENTS selectByPrimaryKey(SALE_PAYMENTSKey key);
	List<SALE_PAYMENTS> selectByskt(SALE_PAYMENTSKey key);
}
