package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_FQKey;
import xb.posservice.dao.vo.SALE_YQ;
import xb.posservice.dao.vo.SALE_YQKey;

public interface SaleyqService {
	// SHOPDEF selectByPrimaryKey(Integer id);
	SALE_YQ selectByPrimaryKey(SALE_YQKey key);

	List<SALE_YQ> selectByskt(SALEKey key);
}
