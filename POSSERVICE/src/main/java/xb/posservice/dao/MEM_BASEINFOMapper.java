package xb.posservice.dao;

import xb.posservice.dao.vo.MEM_BASEINFO;

public interface MEM_BASEINFOMapper {
    int deleteByPrimaryKey(Long hyid);

    int insert(MEM_BASEINFO record);

    int insertSelective(MEM_BASEINFO record);

    MEM_BASEINFO selectByPrimaryKey(Long hyid);

    int updateByPrimaryKeySelective(MEM_BASEINFO record);

    int updateByPrimaryKey(MEM_BASEINFO record);
}