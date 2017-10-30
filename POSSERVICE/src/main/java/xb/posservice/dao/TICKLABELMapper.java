package xb.posservice.dao;

import xb.posservice.dao.vo.TICKLABEL;

public interface TICKLABELMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TICKLABEL record);

    int insertSelective(TICKLABEL record);

    TICKLABEL selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TICKLABEL record);

    int updateByPrimaryKey(TICKLABEL record);
}