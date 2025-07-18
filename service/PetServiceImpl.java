package com.property.management.service;

import com.property.management.entity.Owner;
import com.property.management.entity.Pet;
import com.property.management.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author:  Simon Wayne
 *
 * @Date: 2022/7/15 15:39
 * @version: 1.0
 */
@Service
public class PetServiceImpl implements PetService{
    @Autowired
    private PetMapper petMapper;

    //查询所有宠物
    @Override
    public List<Pet> query(String petName, String startTime, String endTime) {
        return petMapper.selectAllPet(petName,startTime,endTime);
    }
    //查询宠物总条数
    @Override
    public Long queryCount(String petName, String startTime, String endTime) {
        return petMapper.selectAllCount(petName,startTime,endTime);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return petMapper.deleteById(id);
    }

    @Override
    public Boolean deleteByIds(String ids) {
        return petMapper.deleteByIds(ids);
    }

    @Override
    public List<Owner> queryOwnerInfo(Integer id) {
        return petMapper.queryOwner(id);
    }

    @Override
    public Pet queryPetById(Integer id) {
        return petMapper.queryPetById(id);
    }

    @Override
    public Boolean insert(Pet pet) {
        return petMapper.insert(pet);
    }

    @Override
    public Boolean update(Pet pet) {
        return petMapper.update(pet);
    }


}
