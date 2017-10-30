package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.TICK;

public interface TickService {
	 TICK selectByPrimaryKey(Integer id);
	 List<TICK> selectBymall(Integer mdid,Integer dyfs);
}
