package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 专业坦克驾驶员
 * @version 1.0
 * @date 2022年07月14日 20:46
 */
@NoArgsConstructor
@AllArgsConstructor@Data
@Builder
public class Park {
    private long id;
    private long zid;
    private String parkNum;
    private String parkName;
    private Date craterTime;
    private long state;
    private Community community;
}
