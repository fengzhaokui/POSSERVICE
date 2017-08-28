package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.GOODS;

public interface GOODSMapper {
    

    GOODS selectByPrimaryKey(Long spId);
    List<GOODS> selectByshopid(Long shopid);
    
}