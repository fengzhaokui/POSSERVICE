package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.GOODSMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.GoodsService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("GoodsServiceImpl")
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GOODSMapper goodsMapper;

	public GOODS selectByPrimaryKey(Long spId) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByPrimaryKey(spId);
	}

	public List<GOODS> selectByshopid(Long shopid) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByshopid(shopid);
	}

	
	
}
