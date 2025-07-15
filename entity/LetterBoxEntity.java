package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 作者：蔡伟男
 * 版本：1.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LetterBoxEntity {
    private Integer id;
    private String xiaoQu;
    private String letterSource;
    private String letterName;
    private Date creatTime;
    private String state;
}
