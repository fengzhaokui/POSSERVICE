package xb.posservice.dao;

import xb.posservice.dao.vo.SKT_SKFSKey;

public interface SKT_SKFSMapper {
    int deleteByPrimaryKey(SKT_SKFSKey key);

    int insert(SKT_SKFSKey record);

    int insertSelective(SKT_SKFSKey record);
}