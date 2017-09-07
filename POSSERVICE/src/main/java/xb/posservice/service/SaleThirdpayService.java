package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_THIRDPAY;
import xb.posservice.dao.vo.SALE_THIRDPAYKey;

public interface SaleThirdpayService {
	SALE_THIRDPAY selectByPrimaryKey(SALE_THIRDPAYKey key);
	List<SALE_THIRDPAY> selectByskt(SALE_THIRDPAYKey key);
}
