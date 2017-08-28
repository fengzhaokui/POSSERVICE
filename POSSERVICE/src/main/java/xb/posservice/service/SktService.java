package xb.posservice.service;

import xb.posservice.dao.vo.SKT;

public interface SktService {
	 SKT selectByPrimaryKey(String sktno);
	 SKT selectByMaCode(String macode);
}
