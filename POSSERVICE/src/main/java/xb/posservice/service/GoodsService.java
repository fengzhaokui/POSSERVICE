package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.GOODS;

public interface GoodsService {
	// SHOPDEF selectByPrimaryKey(Integer id);
	GOODS selectByPrimaryKey(Long spId);

	List<GOODS> selectByshopid(Long shopid);
}
