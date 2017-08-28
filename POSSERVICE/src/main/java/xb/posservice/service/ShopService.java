package xb.posservice.service;

import xb.posservice.dao.vo.SHOPDEF;

public interface ShopService {
	SHOPDEF selectByPrimaryKey(Integer id);
	 //SKT selectByMaCode(String macode);
}
