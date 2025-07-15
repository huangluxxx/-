package com.property.management.mapper;

import com.property.management.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 专业坦克驾驶员
 * @version 1.0
 * @date 2022年07月12日 14:30
 */


public interface CommunityMapper {


    Integer insert(Community community);

    List<Community> queryByName(@Param("communityName") String communityName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryByNameCount(@Param("communityName") String communityName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Community queryById(Integer id);

    Boolean deleteById(Integer id);

    Boolean deleteCommunityByIds(String ids);

    Boolean updateCommunity(Community community);

}
