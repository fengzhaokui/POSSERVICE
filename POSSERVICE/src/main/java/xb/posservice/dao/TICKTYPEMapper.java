package xb.posservice.dao;

import xb.posservice.dao.vo.TICKTYPE;

public interface TICKTYPEMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TICKTYPE record);

    int insertSelective(TICKTYPE record);

    TICKTYPE selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TICKTYPE record);

    int updateByPrimaryKey(TICKTYPE record);
}