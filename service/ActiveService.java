package com.property.management.service;

import com.property.management.entity.ActiveEntity;

import java.util.List;
//服务层的实现类，它们提供了与数据访问层（Mapper接口）的交互，以执行各种数据库操作。
public interface ActiveService {
    List<ActiveEntity> selectAll(String activeName);

    boolean deleteOne(Integer id);

    boolean addOne(ActiveEntity activeEntity);

    boolean updateOne(ActiveEntity activeEntity);

    ActiveEntity selectId(Integer id);

    Long deleteById(int parseInt);

    Integer selectCount(String activeName);
}
