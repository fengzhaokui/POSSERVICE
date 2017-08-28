package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.SALE_BANKDETAILMapper;
import xb.posservice.dao.vo.SALE_BANKDETAIL;
import xb.posservice.dao.vo.SALE_BANKDETAILKey;
import xb.posservice.service.SaleBankdetailService;
@Service("SaleBankdetailServiceImpl")
public class SaleBankdetailServiceImpl implements SaleBankdetailService{
	@Autowired
	SALE_BANKDETAILMapper mapper;
	public int insert(SALE_BANKDETAIL record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}
	public SALE_BANKDETAIL selectByPrimaryKey(SALE_BANKDETAILKey key) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(key);
	}
	public SALE_BANKDETAIL selectByskt(SALE_BANKDETAILKey key) {
		// TODO Auto-generated method stub
		return mapper.selectByskt(key);
	}

}
