package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.TICKMapper;
import xb.posservice.dao.vo.TICK;
import xb.posservice.service.TickService;
@Service("TickServiceImpl")
public class TickServiceImpl implements TickService{
	@Autowired
	TICKMapper myMapper;
	
	//@Override
	public TICK selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return myMapper.selectByPrimaryKey(id);
	}

	public List<TICK> selectBymall(Integer mdid, Integer dyfs) {
		// TODO Auto-generated method stub
		return myMapper.selectBymall(mdid, dyfs);
	}

	
	
}
