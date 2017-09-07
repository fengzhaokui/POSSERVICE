package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_CLERK;
import xb.posservice.dao.vo.HIS_SALE_CLERKKey;
import xb.posservice.dao.vo.SALE_CLERKKey;

public interface HisSaleClerkService {
	HIS_SALE_CLERK selectByPrimaryKey(HIS_SALE_CLERKKey key);
	List<HIS_SALE_CLERK> selectByskt(SALE_CLERKKey key);
}
