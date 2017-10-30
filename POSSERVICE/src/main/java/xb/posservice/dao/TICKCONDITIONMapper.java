package xb.posservice.dao;

import xb.posservice.dao.vo.TICKCONDITION;

public interface TICKCONDITIONMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TICKCONDITION record);

    int insertSelective(TICKCONDITION record);

    TICKCONDITION selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TICKCONDITION record);

    int updateByPrimaryKey(TICKCONDITION record);
}