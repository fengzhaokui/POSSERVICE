package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.TOKENMapper;
import xb.posservice.dao.vo.TOKEN;
import xb.posservice.service.TokenService;
@Service("TokenServiceImpl")
public class TokenServiceImpl implements TokenService{
	@Autowired
	TOKENMapper tokenMapper;
	
	//@Override
	public TOKEN selectByPrimaryKey(String tokenguid) {
		// TODO Auto-generated method stub
		return tokenMapper.selectByPrimaryKey(tokenguid);
	}

	public int insert(TOKEN record) {
		// TODO Auto-generated method stub
		return tokenMapper.insert(record);
	}
	
	
}
