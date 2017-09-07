package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.SALEMapper;
import xb.posservice.dao.SALE_CLERKMapper;
import xb.posservice.dao.SALE_DETAILMapper;
import xb.posservice.dao.SALE_FQMapper;
import xb.posservice.dao.SALE_YQMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_CLERK;
import xb.posservice.dao.vo.SALE_CLERKKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_FQKey;
import xb.posservice.dao.vo.SALE_YQ;
import xb.posservice.dao.vo.SALE_YQKey;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.SaleClerkService;
import xb.posservice.service.SaleDetailService;
import xb.posservice.service.SaleService;
import xb.posservice.service.SalefqService;
import xb.posservice.service.SaleyqService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("SaleyqServiceImpl")
public class SaleyqServiceImpl implements SaleyqService{
	@Autowired
	SALE_YQMapper myMapper;
	
	

	public SALE_YQ selectByPrimaryKey(SALE_YQKey key) {
		return myMapper.selectByPrimaryKey(key);
	}

	public List<SALE_YQ> selectByskt(SALEKey key) {
		// TODO Auto-generated method stub
		return myMapper.selectByskt(key);
	}

	
	
}
