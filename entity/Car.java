package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆管理实体类
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Serializable 对象序列化的接口，一个类只有实现了Serializable接口，它的对象才能被序列化
//如果一个类实现了 Serializable 接口，那么它的对象可以被转换成字节流，这些字节流可以被存储到文件中或通过网络发送。
// 然后，这些字节流可以被反序列化回原始的对象形式。
public class Car  {
//自定义一个serialVersionUID
  private static final long serialVersionUID=-53440701877036285L;
//serialVersionUID 是一个用于版本控制的唯一标识符，它确保了在序列化和反序列化过程中，发送方和接收方对类的版本有一致的预期。
  private long id;
  private long oid;
  private String carNumber;
  private String color;
  private String picture;
  private String remark;
  private Date createTime;
  private Owner owner;



}
