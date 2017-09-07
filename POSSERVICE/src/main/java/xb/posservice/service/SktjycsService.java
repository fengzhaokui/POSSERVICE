package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.SKTJYCS;
import xb.posservice.dao.vo.SKTJYCSKey;
import xb.posservice.dao.vo.SKTRB;
import xb.posservice.dao.vo.SKTRBKey;

public interface SktjycsService {
	List<SKTJYCS> selectByPrimaryKey(SKTJYCSKey key);
}
