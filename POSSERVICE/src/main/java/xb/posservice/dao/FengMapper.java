package xb.posservice.dao;


import java.util.List;
import java.util.Map;

import xb.posservice.dao.vo.MemberBaseInfo;

public interface FengMapper {
	MemberBaseInfo getMemberInfoByhyId(Integer hyid);
	List<MemberBaseInfo> getAllMemberInfo();
	Long addMemberInfo(MemberBaseInfo memberInfo);
	void WRITE_SKTRB(Map<String, Object> map);
}
