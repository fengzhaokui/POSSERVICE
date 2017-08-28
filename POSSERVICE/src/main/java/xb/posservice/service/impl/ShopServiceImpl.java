package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("ShopServiceImpl")
public class ShopServiceImpl implements ShopService{
	@Autowired
	SHOPDEFMapper shopMapper;
	
	//@Override
	public SHOPDEF selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return shopMapper.selectByPrimaryKey(id);
	}

	
	
}
