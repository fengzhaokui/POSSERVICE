package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_THIRDPAY;
import xb.posservice.dao.vo.HIS_SALE_THIRDPAYKey;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_THIRDPAY;
import xb.posservice.dao.vo.SALE_THIRDPAYKey;

public interface HisSaleThirdpayService {
	HIS_SALE_THIRDPAY selectByPrimaryKey(HIS_SALE_THIRDPAYKey key);
	List<HIS_SALE_THIRDPAY> selectByskt(SALE_THIRDPAYKey key);
}
