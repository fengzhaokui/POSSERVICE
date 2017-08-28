package xb.posservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xb.posservice.dao.vo.PERSONINFO;

public interface PERSONINFOMapper {
    int deleteByPrimaryKey(Long personId);

    int insert(PERSONINFO record);

    int insertSelective(PERSONINFO record);

    PERSONINFO selectByPrimaryKey(Long personId);
    PERSONINFO selectByrydm(@Param("personId")Long personId,@Param("shopid")Integer shopid);
    List<PERSONINFO> selectByshop(Long shopid);

    int updateByPrimaryKeySelective(PERSONINFO record);

    int updateByPrimaryKey(PERSONINFO record);
}