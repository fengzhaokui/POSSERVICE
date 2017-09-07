package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_DETAIL;
import xb.posservice.dao.vo.HIS_SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_DETAILKey;

public interface HisSaleDetailService {
	HIS_SALE_DETAIL selectByPrimaryKey(HIS_SALE_DETAILKey key);
	List<HIS_SALE_DETAIL> selectByskt(SALE_DETAILKey key);
}
