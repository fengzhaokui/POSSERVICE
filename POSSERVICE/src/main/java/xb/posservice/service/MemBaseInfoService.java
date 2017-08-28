package xb.posservice.service;

import xb.posservice.dao.vo.MEM_BASEINFO;

public interface MemBaseInfoService {
	 MEM_BASEINFO selectByPrimaryKey(Long hyid);
}
