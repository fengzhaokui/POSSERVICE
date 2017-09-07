package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_PAYMENTS;
import xb.posservice.dao.vo.HIS_SALE_PAYMENTSKey;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_PAYMENTS;
import xb.posservice.dao.vo.SALE_PAYMENTSKey;

public interface HisSalePaymentsService {
	HIS_SALE_PAYMENTS selectByPrimaryKey(HIS_SALE_PAYMENTSKey key);
	List<HIS_SALE_PAYMENTS> selectByskt(SALE_PAYMENTSKey key);
}
