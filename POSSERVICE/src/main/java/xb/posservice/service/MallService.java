package xb.posservice.service;

import xb.posservice.dao.vo.MALLDEF;

public interface MallService {
	MALLDEF selectByPrimaryKey(Integer id);
	 //SKT selectByMaCode(String macode);
}
