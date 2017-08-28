package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.SKFSMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.SKFS;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.SkfsService;
import xb.posservice.service.SktService;
@Service("SkfsServiceImpl")
public class SkfsServiceImpl implements SkfsService{
	@Autowired
	SKFSMapper skfsMapper;
	
	

	public SKFS selectByPrimaryKey(Integer code) {
		// TODO Auto-generated method stub
		return skfsMapper.selectByPrimaryKey(code);
	}

	public List<SKFS> selectByskt(String code) {
		// TODO Auto-generated method stub
		return skfsMapper.selectByskt(code);
	}
	
	
}
