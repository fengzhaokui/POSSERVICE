package xb.posservice.dao;

import xb.posservice.dao.vo.SKT;

public interface SKTMapper {
    int deleteByPrimaryKey(String sktno);

    int insert(SKT record);

    int insertSelective(SKT record);

    SKT selectByPrimaryKey(String sktno);
    
    SKT selectByMaCode(String macode);

    int updateByPrimaryKeySelective(SKT record);

    int updateByPrimaryKey(SKT record);
}