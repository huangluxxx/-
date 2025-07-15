package com.property.management.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//用方便的方式来创建 RespBean 实例，而无需直接调用构造函数。
//RespBean 类通常用于 Web 应用程序的后端，作为控制器方法返回给前端的数据封装。
// 通过这种方式，前端可以很容易地解析响应的状态、信息和数据。
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private Integer status;
    private String info;
    private Object data;



    public static RespBean ok(String info, Object data) {
        return new RespBean(200, info, data);
    }


    public static RespBean ok(String info) {
        return new RespBean(200, info, null);
    }

    public static RespBean error(String info, Object data) {
        return new RespBean(500, info, data);
    }


    public static RespBean error(String info) {
        return new RespBean(500, info, null);
    }


}
