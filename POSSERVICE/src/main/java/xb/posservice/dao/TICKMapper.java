package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.TICK;

public interface TICKMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TICK record);

    int insertSelective(TICK record);

    TICK selectByPrimaryKey(Integer id);
    List<TICK> selectBymall(Integer mdid,Integer dyfs);

    int updateByPrimaryKeySelective(TICK record);

    int updateByPrimaryKey(TICK record);
}