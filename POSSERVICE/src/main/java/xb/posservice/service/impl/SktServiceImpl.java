package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.SktService;
@Service("SktServiceImpl")
public class SktServiceImpl implements SktService{
	@Autowired
	SKTMapper sktMapper;
	
	//@Override
	public SKT selectByPrimaryKey(String sktno) {
		// TODO Auto-generated method stub
		return sktMapper.selectByPrimaryKey(sktno);
	}

	public SKT selectByMaCode(String macode) {
		// TODO Auto-generated method stub
		return sktMapper.selectByMaCode(macode);
	}
	
	
}
