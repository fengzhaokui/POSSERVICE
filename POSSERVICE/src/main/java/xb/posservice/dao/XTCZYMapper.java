package xb.posservice.dao;

import xb.posservice.dao.vo.XTCZY;

public interface XTCZYMapper {
    int deleteByPrimaryKey(Long personId);

    int insert(XTCZY record);

    int insertSelective(XTCZY record);

    XTCZY selectByPrimaryKey(Long personId);
    XTCZY selectByPWD(XTCZY xtczy);

    int updateByPrimaryKeySelective(XTCZY record);

    int updateByPrimaryKeyWithBLOBs(XTCZY record);

    int updateByPrimaryKey(XTCZY record);
}