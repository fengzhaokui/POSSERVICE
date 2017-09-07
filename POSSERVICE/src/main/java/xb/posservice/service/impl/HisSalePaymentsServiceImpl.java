package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.HIS_SALE_PAYMENTSMapper;
import xb.posservice.dao.SALEMapper;
import xb.posservice.dao.SALE_DETAILMapper;
import xb.posservice.dao.SALE_PAYMENTSMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.HIS_SALE_PAYMENTS;
import xb.posservice.dao.vo.HIS_SALE_PAYMENTSKey;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_PAYMENTS;
import xb.posservice.dao.vo.SALE_PAYMENTSKey;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.HisSalePaymentsService;
import xb.posservice.service.SaleDetailService;
import xb.posservice.service.SalePaymentsService;
import xb.posservice.service.SaleService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("HisSalePaymentsServiceImpl")
public class HisSalePaymentsServiceImpl implements HisSalePaymentsService{
	@Autowired
	HIS_SALE_PAYMENTSMapper myMapper;
	
	public HIS_SALE_PAYMENTS selectByPrimaryKey(HIS_SALE_PAYMENTSKey key) {
		// TODO Auto-generated method stub
		return myMapper.selectByPrimaryKey(key);
	}

	public List<HIS_SALE_PAYMENTS> selectByskt(SALE_PAYMENTSKey key) {
		// TODO Auto-generated method stub
		return myMapper.selectByskt(key);
	}

	
	
}
