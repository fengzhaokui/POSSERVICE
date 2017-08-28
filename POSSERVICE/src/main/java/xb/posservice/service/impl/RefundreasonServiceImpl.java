package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.MALLDEFMapper;
import xb.posservice.dao.REFUNDREASONMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.MALLDEF;
import xb.posservice.dao.vo.REFUNDREASON;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.MallService;
import xb.posservice.service.RefundreasonService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("RefundreasonServiceImpl")
public class RefundreasonServiceImpl implements RefundreasonService{
	@Autowired
	REFUNDREASONMapper mallMapper;

	public List<REFUNDREASON> selectall() {
		// TODO Auto-generated method stub
		return mallMapper.selectall();
	}

	
	
}
