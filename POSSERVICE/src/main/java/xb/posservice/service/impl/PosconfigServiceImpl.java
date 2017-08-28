package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.POSCONFIGMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.POSCONFIG;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.PosconfigService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("PosconfigServiceImpl")
public class PosconfigServiceImpl implements PosconfigService{
	@Autowired
	POSCONFIGMapper ponconfigMapper;
	
	
	public List<POSCONFIG> getAllPosconfig() {
		// TODO Auto-generated method stub
		return ponconfigMapper.getAllPosconfig();
	}

	
	
}
