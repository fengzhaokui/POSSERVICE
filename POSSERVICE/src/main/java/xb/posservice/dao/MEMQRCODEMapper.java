package xb.posservice.dao;

import xb.posservice.dao.vo.MEMQRCODE;
import xb.posservice.dao.vo.MEMQRCODEKey;

public interface MEMQRCODEMapper {
    int deleteByPrimaryKey(MEMQRCODEKey key);

    int insert(MEMQRCODE record);

    int insertSelective(MEMQRCODE record);

    MEMQRCODE selectByPrimaryKey(MEMQRCODEKey key);
    
    MEMQRCODE selectByQRCODE(String qrcode);

    int updateByPrimaryKeySelective(MEMQRCODE record);

    int updateByPrimaryKey(MEMQRCODE record);
}