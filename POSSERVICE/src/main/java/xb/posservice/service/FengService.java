package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.MemberBaseInfo;

public interface FengService {

	MemberBaseInfo getMemberInfoByhyId(Integer hyid);
	List<MemberBaseInfo> getAllMemberInfo();
	Long addMemberInfo(MemberBaseInfo memberInfo);
}
