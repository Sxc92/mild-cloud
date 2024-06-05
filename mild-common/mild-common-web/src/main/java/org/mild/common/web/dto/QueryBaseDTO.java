package org.mild.common.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Data
public class QueryBaseDTO implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 主键集合
     */
    private List<String> ids;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
