package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.HIS_SALEMapper;
import xb.posservice.dao.MEM_TYPEDEFMapper;
import xb.posservice.dao.SALEMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.HIS_SALE;
import xb.posservice.dao.vo.MEM_TYPEDEF;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.HisSaleService;
import xb.posservice.service.MemTypedefService;
import xb.posservice.service.SaleService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("MemTypedefServiceImpl")
public class MemTypedefServiceImpl implements MemTypedefService{
	@Autowired
	MEM_TYPEDEFMapper myMapper;
	public MEM_TYPEDEF selectByPrimaryKey(Long hyktype) {
		// TODO Auto-generated method stub
		return myMapper.selectByPrimaryKey(hyktype);
	}

	
	
}
