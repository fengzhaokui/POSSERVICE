package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.PERSONINFOMapper;
import xb.posservice.dao.vo.PERSONINFO;
import xb.posservice.service.PersoninfoService;

@Service("PersoninfoServiceImpl")
public class PersoninfoServiceImpl implements PersoninfoService{
	@Autowired
	PERSONINFOMapper personinfoMapper;
	
	public PERSONINFO selectByPrimaryKey(long personId) {
		// TODO Auto-generated method stub
		return personinfoMapper.selectByPrimaryKey(personId);
	}
	public PERSONINFO selectByrydm(long personId,Integer shopid) {
		// TODO Auto-generated method stub
		return personinfoMapper.selectByrydm(personId, shopid);
	}
	public List<PERSONINFO> selectByshop(Long shopid) {
		// TODO Auto-generated method stub
		return personinfoMapper.selectByshop(shopid);
	}

}
