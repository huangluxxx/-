package com.property.management.service;

import com.property.management.entity.LetterBoxEntity;

import java.util.List;

public interface LetterBoxService {
    List<LetterBoxEntity> selectAll(String litterBoxName);

    Integer selectCount(String litterBoxName);

    boolean deleteOne(Integer id);

    boolean addOne(LetterBoxEntity letterBoxEntity);

    LetterBoxEntity selectId(Integer id);

    boolean updateOne(LetterBoxEntity letterBoxEntity);

    Long deleteById(int parseInt);
}
