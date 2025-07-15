package com.property.management.mapper;

import com.property.management.entity.ActiveEntity;

import java.util.List;
//操作各种数据库操作·，比如资产，用户，建筑等等的数据库操作
//Activemapper接口为ActiveEntity相关的数据库操作提供了一个抽象层
// 使得其他层（特别是表现层）可以通过调用这些服务方法来执行业务逻辑，而无需直接关注数据库操作的具体实现细节。
public interface ActiveMapper {
    List<ActiveEntity> selectAll(String activeName);
    Long deleteOne(Integer id);
    Long addOne(ActiveEntity activeEntity);
    Long updateOne(ActiveEntity activeEntity);

    ActiveEntity selectId(Integer id);

    Long deleteById(int parseInt);

    Integer selectCount(String activeName);
}
