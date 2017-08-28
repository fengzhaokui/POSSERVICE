package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.POSCONFIG;

public interface POSCONFIGMapper {
    int deleteByPrimaryKey(Long jlbh);

    int insert(POSCONFIG record);

    int insertSelective(POSCONFIG record);

    POSCONFIG selectByPrimaryKey(Long jlbh);
    List<POSCONFIG> getAllPosconfig();
    int updateByPrimaryKeySelective(POSCONFIG record);

    int updateByPrimaryKey(POSCONFIG record);
}