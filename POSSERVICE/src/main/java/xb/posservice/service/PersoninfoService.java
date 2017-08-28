package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.PERSONINFO;;

public interface PersoninfoService {
	PERSONINFO selectByPrimaryKey(long personId );
	PERSONINFO selectByrydm(long personId,Integer shopid );
	List<PERSONINFO> selectByshop(Long shopid);
}
