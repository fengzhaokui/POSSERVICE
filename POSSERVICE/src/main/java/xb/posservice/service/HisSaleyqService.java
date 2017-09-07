package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.HIS_SALE_YQ;
import xb.posservice.dao.vo.HIS_SALE_YQKey;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_FQKey;
import xb.posservice.dao.vo.SALE_YQ;
import xb.posservice.dao.vo.SALE_YQKey;

public interface HisSaleyqService {
	// SHOPDEF selectByPrimaryKey(Integer id);
	HIS_SALE_YQ selectByPrimaryKey(HIS_SALE_YQKey key);

	List<HIS_SALE_YQ> selectByskt(SALEKey key);
}
