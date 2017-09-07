package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.HIS_SALE_BANKDETAILMapper;
import xb.posservice.dao.SALE_BANKDETAILMapper;
import xb.posservice.dao.vo.HIS_SALE_BANKDETAIL;
import xb.posservice.dao.vo.HIS_SALE_BANKDETAILKey;
import xb.posservice.dao.vo.SALE_BANKDETAIL;
import xb.posservice.dao.vo.SALE_BANKDETAILKey;
import xb.posservice.service.HisSaleBankdetailService;
import xb.posservice.service.SaleBankdetailService;
@Service("HisSaleBankdetailServiceImpl")
public class HisSaleBankdetailServiceImpl implements HisSaleBankdetailService{
	@Autowired
	HIS_SALE_BANKDETAILMapper mapper;
	public int insert(HIS_SALE_BANKDETAIL record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}
	public HIS_SALE_BANKDETAIL selectByPrimaryKey(HIS_SALE_BANKDETAILKey key) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(key);
	}
	public List<HIS_SALE_BANKDETAIL> selectByskt(SALE_BANKDETAILKey key) {
		// TODO Auto-generated method stub
		return mapper.selectByskt(key);
	}
	public HIS_SALE_BANKDETAIL selectoneByskt(SALE_BANKDETAILKey key) {
		// TODO Auto-generated method stub
		return mapper.selectoneByskt(key);
	}

}
