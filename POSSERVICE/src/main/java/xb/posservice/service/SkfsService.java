package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.SKFS;
import xb.posservice.dao.vo.SKT;

public interface SkfsService {
	 SKFS selectByPrimaryKey(Integer code);
	    
	    List<SKFS> selectByskt(String code);
}
