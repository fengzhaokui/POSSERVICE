package xb.posservice.service;

import xb.posservice.dao.vo.XTCZY;

public interface XtczyService {
	XTCZY selectByPrimaryKey(Long personId);

	XTCZY selectByPWD(XTCZY xtczy);
	 int updateByPrimaryKeySelective(XTCZY record);
}
