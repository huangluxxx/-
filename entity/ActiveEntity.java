package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//使用Lombok来减少样板代码，同时定义了活动相关属性的Java实体类。
/**
 * 作者：黄璐
 * 版本：1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ActiveEntity {
    private Integer id;
    private String xiaoQu;
    private String activeName;
    private String activePath;
    private String activeMaster;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;
    private String state;
    private String activeBody;
}
