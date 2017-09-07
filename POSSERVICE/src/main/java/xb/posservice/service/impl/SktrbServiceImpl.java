package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.GOODSMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.SKTRBMapper;
import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.dao.vo.SKTJYCS;
import xb.posservice.dao.vo.SKTJYCSKey;
import xb.posservice.dao.vo.SKTRB;
import xb.posservice.dao.vo.SKTRBKey;
import xb.posservice.service.GoodsService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
import xb.posservice.service.SktrbService;
@Service("SktrbServiceImpl")
public class SktrbServiceImpl implements SktrbService{
	@Autowired
	SKTRBMapper myMapper;
	public List<SKTRB> selectByPrimaryKey(SKTRBKey key) {
		// TODO Auto-generated method stub
		return myMapper.selectByPrimaryKey(key);
	}
}
