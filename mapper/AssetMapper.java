package com.property.management.mapper;

import com.property.management.entity.Asset;
import com.property.management.entity.Charge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetMapper {
    List<Asset> queryByName(@Param("rateName") String rateName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryByNameCount(@Param("rateName") String rateName, @Param("startTime")String startTime, @Param("endTime")String endTime);

    int deleteAssetById(Integer id);

    int deleteAssetByIds(String ids);

    Asset queryAssetInfoById(Integer id);

    List<Charge> queryAll();

    int updateAsset(Asset asset);

    List<Charge> selectRate(String cName);

    int insertAsset(Asset asset);
}
