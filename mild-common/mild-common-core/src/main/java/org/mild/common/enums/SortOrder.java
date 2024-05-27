package org.mild.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 史偕成
 * @date 2024/05/19 22:10
 **/
@Getter
@AllArgsConstructor
public enum SortOrder {
    /**
     * 降序
     */
    DESC("desc"),

    /**
     * 升序
     */
    ASC("asc");

    private final String code;
}
