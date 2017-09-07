package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.HIS_SALE_FQ;
import xb.posservice.dao.vo.HIS_SALE_FQKey;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_FQKey;

public interface HisSalefqService {
	// SHOPDEF selectByPrimaryKey(Integer id);
	HIS_SALE_FQ selectByPrimaryKey(HIS_SALE_FQKey key);

	List<HIS_SALE_FQ> selectByskt(SALEKey key);
}
