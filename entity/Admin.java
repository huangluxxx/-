package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//通过Lombok注解，Admin类自动获得了构造函数、getter和setter方法、toString、equals和hashCode方法的实现。
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Admin extends User{
  private String rolename;
}
