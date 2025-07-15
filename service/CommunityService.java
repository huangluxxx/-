package com.property.management.service;

import com.property.management.entity.Community;

import java.util.List;

/**
 * @author 专业坦克驾驶员
 * @version 1.0
 * @date 2022年07月12日 14:31
 */
public interface CommunityService {

     Integer insertInfo(Community community);

    List<Community> queryByName(String communityName, String startTime, String endTime);

    Long queryByNameCount(String communityName, String startTime, String endTime);

    Community queryById(Integer id);

    Boolean deleteById(Integer id);

    Boolean deleteCommunityByIds(String ids);

    Boolean updateCommunity(Community community);

}
