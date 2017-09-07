package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_FQKey;

public interface SalefqService {
	// SHOPDEF selectByPrimaryKey(Integer id);
	SALE_FQ selectByPrimaryKey(SALE_FQKey key);

	List<SALE_FQ> selectByskt(SALEKey key);
}
