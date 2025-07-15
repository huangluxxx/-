package com.property.management.service;

import com.property.management.entity.Owner;
import com.property.management.entity.Pet;

import java.util.List;

/**
 * Author:  Simon Wayne
 *
 * @Date: 2022/7/15 15:38
 * @version: 1.0
 */

public interface PetService {
    //查询所有宠物
    List<Pet> query(String petName, String startTime, String endTime);
//查询宠物总条数
    Long queryCount(String petName, String startTime, String endTime);
//根据id进行单个删除
    Boolean deleteById(Integer id);
    //根据ids进行批量删除
    Boolean deleteByIds(String ids);
//添加时渲染宠物主人下拉框
    List<Owner> queryOwnerInfo(Integer id);
//更新数据时回显的宠物信息
    Pet queryPetById(Integer id);
//插入宠物数据信息
    Boolean insert(Pet pet);
//更新宠物信息
    Boolean update(Pet pet);
}
