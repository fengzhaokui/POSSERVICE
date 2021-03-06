package xb.posservice.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xb.posservice.dao.FengMapper;
import xb.posservice.dao.vo.MemberBaseInfo;
import xb.posservice.service.FengService;

@Service
public class FengServiceImpl implements FengService{
	
	@Autowired
	FengMapper fengMapper;
	
	//@Override
	public MemberBaseInfo getMemberInfoByhyId(Integer hyid) {
		return fengMapper.getMemberInfoByhyId(hyid);
	}
	//@Override
	public List<MemberBaseInfo> getAllMemberInfo() {
		return fengMapper.getAllMemberInfo();
	}
	//@Override
	public Long addMemberInfo(MemberBaseInfo memberInfo) {
		return fengMapper.addMemberInfo(memberInfo);
	}
	public void WRITE_SKTRB(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 fengMapper.WRITE_SKTRB(map);
	}
}
