package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.REFUNDREASON;

public interface REFUNDREASONMapper {
    int deleteByPrimaryKey(Long id);

    int insert(REFUNDREASON record);

    int insertSelective(REFUNDREASON record);

    REFUNDREASON selectByPrimaryKey(Long id);
    List<REFUNDREASON> selectall();

    int updateByPrimaryKeySelective(REFUNDREASON record);

    int updateByPrimaryKey(REFUNDREASON record);
}