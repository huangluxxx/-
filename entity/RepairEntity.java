package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 作者：黄璐
 * 版本：1.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairEntity {
    private Integer id;
    private String xiaoQu;
    private String repairPersonnel;
    private String repairThing;
    private String repairDescription;
    private Date creatTime;
    private String state;
}
