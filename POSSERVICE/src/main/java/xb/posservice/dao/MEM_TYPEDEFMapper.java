package xb.posservice.dao;

import xb.posservice.dao.vo.MEM_TYPEDEF;

public interface MEM_TYPEDEFMapper {
    int deleteByPrimaryKey(Long hyktype);

    int insert(MEM_TYPEDEF record);

    int insertSelective(MEM_TYPEDEF record);

    MEM_TYPEDEF selectByPrimaryKey(Long hyktype);

    int updateByPrimaryKeySelective(MEM_TYPEDEF record);

    int updateByPrimaryKey(MEM_TYPEDEF record);
}