package xb.posservice.service;

import xb.posservice.dao.vo.HIS_SALE;
import xb.posservice.dao.vo.MEM_TYPEDEF;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;

public interface MemTypedefService {
	 MEM_TYPEDEF selectByPrimaryKey(Long hyktype);
}
