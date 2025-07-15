package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//功能：减少样板代码
//序列化机制需要无参数的构造函数来创建对象的新实例。
//Asset类是一个使用Lombok注解来减少样板代码的Java类，它包含了一系列与资产相关的字段
// 并通过这些Lombok注解自动获得了构造函数、getter和setter方法、toString、equals和hashCode方法的实现，以及一个用于链式构建对象的Builder类。
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Asset {

  private long id;
  private String communityName;
  private String rateName;
  private String owner;
  private String amount;
  private String figure;
  private Date figureDate;
  private String remark;
  private Date createDate;

}
