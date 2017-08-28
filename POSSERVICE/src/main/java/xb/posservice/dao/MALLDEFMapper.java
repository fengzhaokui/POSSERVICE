package xb.posservice.dao;

import xb.posservice.dao.vo.MALLDEF;

public interface MALLDEFMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MALLDEF record);

    int insertSelective(MALLDEF record);

    MALLDEF selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MALLDEF record);

    int updateByPrimaryKey(MALLDEF record);
}