package com.property.management.mapper;

import com.property.management.entity.Community;
import com.property.management.entity.Park;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 专业坦克驾驶员
 * @version 1.0
 * @date 2022年07月14日 11:34
 */
public interface ParkMapper {
   List<Community> queryCommunityInfo(Integer id);

   List<Park> queryByName(@Param("parkName") String parkName, @Param("startTime")  String startTime, @Param("endTime")  String endTime);

   Long queryByNameCount(@Param("parkName") String parkName,@Param("startTime")  String startTime,@Param("endTime")  String endTime);

   Boolean deleteById(Integer id);


   Boolean deleteByIds(String ids);

   boolean insertInfo(Park park);

    Community queryById(Integer id);

   Park queryId(Integer id);

   Boolean updatePark(Park park);

}
