package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SKFS;

public interface SKFSMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(SKFS record);

    int insertSelective(SKFS record);

    SKFS selectByPrimaryKey(Integer code);
    
    List<SKFS> selectByskt(String sktno);

    int updateByPrimaryKeySelective(SKFS record);

    int updateByPrimaryKey(SKFS record);
}