package org.mild.common.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Data
public class BaseDTO implements Serializable {

    private String createBy;

    private LocalDateTime createTime;
}
