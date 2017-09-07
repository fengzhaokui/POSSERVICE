package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.SALEMapper;
import xb.posservice.dao.SALE_CLERKMapper;
import xb.posservice.dao.SALE_DETAILMapper;
import xb.posservice.dao.SALE_THIRDPAYMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_CLERK;
import xb.posservice.dao.vo.SALE_CLERKKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_THIRDPAY;
import xb.posservice.dao.vo.SALE_THIRDPAYKey;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.SaleClerkService;
import xb.posservice.service.SaleDetailService;
import xb.posservice.service.SaleService;
import xb.posservice.service.SaleThirdpayService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("SaleThirdpayServiceImpl")
public class SaleThirdpayServiceImpl implements SaleThirdpayService{
	@Autowired
	SALE_THIRDPAYMapper myMapper;
	public SALE_THIRDPAY selectByPrimaryKey(SALE_THIRDPAYKey key) {
		// TODO Auto-generated method stub
		return myMapper.selectByPrimaryKey(key);
	}

	public List<SALE_THIRDPAY> selectByskt(SALE_THIRDPAYKey key) {
		// TODO Auto-generated method stub
		return myMapper.selectByskt(key);
	}

	
	
}
