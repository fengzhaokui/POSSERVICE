package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.MALLDEFMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.MALLDEF;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.MallService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("MallServiceImpl")
public class MallServiceImpl implements MallService{
	@Autowired
	MALLDEFMapper mallMapper;
	
	//@Override
	public MALLDEF selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mallMapper.selectByPrimaryKey(id);
	}

	
	
}
