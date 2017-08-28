package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.GOODSMapper;
import xb.posservice.dao.MEM_BASEINFOMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.MEM_BASEINFO;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.GoodsService;
import xb.posservice.service.MemBaseInfoService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("MemBaseInfoServiceImpl")
public class MemBaseInfoServiceImpl implements MemBaseInfoService{
	@Autowired
	MEM_BASEINFOMapper memMapper;

	public MEM_BASEINFO selectByPrimaryKey(Long hyid) {
		// TODO Auto-generated method stub
		return memMapper.selectByPrimaryKey(hyid);
	}
	
}
