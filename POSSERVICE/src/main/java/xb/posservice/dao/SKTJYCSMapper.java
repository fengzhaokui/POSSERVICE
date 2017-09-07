package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SKTJYCS;
import xb.posservice.dao.vo.SKTJYCSKey;

public interface SKTJYCSMapper {
    int deleteByPrimaryKey(SKTJYCSKey key);

    int insert(SKTJYCS record);

    int insertSelective(SKTJYCS record);

    List<SKTJYCS> selectByPrimaryKey(SKTJYCSKey key);

    int updateByPrimaryKeySelective(SKTJYCS record);

    int updateByPrimaryKey(SKTJYCS record);
}