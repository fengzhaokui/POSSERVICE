package xb.posservice.dao;

import xb.posservice.dao.vo.TOKEN;

public interface TOKENMapper {
    
    TOKEN selectByPrimaryKey(String tokenguid);
    int insert(TOKEN record);
 
}