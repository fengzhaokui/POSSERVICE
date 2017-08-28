package xb.posservice.service;

import xb.posservice.dao.vo.TOKEN;

public interface TokenService {
	 TOKEN selectByPrimaryKey(String tokenguid);
	 int insert(TOKEN record);
}
