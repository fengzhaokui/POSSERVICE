package xb.posservice.dao;

import xb.posservice.dao.vo.SHOPDEF;

public interface SHOPDEFMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SHOPDEF record);

    int insertSelective(SHOPDEF record);

    SHOPDEF selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SHOPDEF record);

    int updateByPrimaryKeyWithBLOBs(SHOPDEF record);

    int updateByPrimaryKey(SHOPDEF record);
}