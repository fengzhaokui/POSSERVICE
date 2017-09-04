package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.TOKENMapper;
import xb.posservice.dao.XTCZYMapper;
import xb.posservice.dao.vo.TOKEN;
import xb.posservice.dao.vo.XTCZY;
import xb.posservice.service.TokenService;
import xb.posservice.service.XtczyService;
@Service("XtczyServiceImpl")
public class XtczyServiceImpl implements XtczyService{
	@Autowired
	XTCZYMapper tokenMapper;

	public XTCZY selectByPrimaryKey(Long personId) {
		// TODO Auto-generated method stub
		return tokenMapper.selectByPrimaryKey(personId);
	}

	public XTCZY selectByPWD(XTCZY xtczy) {
		// TODO Auto-generated method stub
		return tokenMapper.selectByPWD(xtczy);
	}

	public int updateByPrimaryKeySelective(XTCZY record) {
		// TODO Auto-generated method stub
		return tokenMapper.updateByPrimaryKeySelective(record);
	}
	
	
}
