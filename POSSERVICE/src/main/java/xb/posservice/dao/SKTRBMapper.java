package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SKTRB;
import xb.posservice.dao.vo.SKTRBKey;

public interface SKTRBMapper {
    int deleteByPrimaryKey(SKTRBKey key);

    int insert(SKTRB record);

    int insertSelective(SKTRB record);

    List<SKTRB> selectByPrimaryKey(SKTRBKey key);

    int updateByPrimaryKeySelective(SKTRB record);

    int updateByPrimaryKey(SKTRB record);
}