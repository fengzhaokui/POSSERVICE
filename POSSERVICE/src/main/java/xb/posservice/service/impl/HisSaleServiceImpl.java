package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.HIS_SALEMapper;
import xb.posservice.dao.SALEMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.HIS_SALE;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.HisSaleService;
import xb.posservice.service.SaleService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("HisSaleServiceImpl")
public class HisSaleServiceImpl implements HisSaleService{
	@Autowired
	HIS_SALEMapper saleMapper;
	
	

	public HIS_SALE selectByPrimaryKey(SALEKey key) {
		// TODO Auto-generated method stub
		return saleMapper.selectByPrimaryKey(key);
	}

	public HIS_SALE selectMaxJlbh(String sktno) {
		// TODO Auto-generated method stub
		return saleMapper.selectMaxJlbh(sktno);
	}

	
	
}
