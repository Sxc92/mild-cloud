package org.mild.common.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.enums.SortOrder;

import java.io.Serializable;

/**
 * @author 史偕成
 * @date 2024/05/19 22:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryPage extends QueryBaseDTO {

    /**
     * 每页条数
     */
    private long pageSize;

    /**
     * 页码
     */
    private long pageNo;

    /**
     * 排序方式
     * {@link SortOrder}
     */
    private String sortOrder;

    /**
     * 排序字段
     */
    private String sortFiled;
}
