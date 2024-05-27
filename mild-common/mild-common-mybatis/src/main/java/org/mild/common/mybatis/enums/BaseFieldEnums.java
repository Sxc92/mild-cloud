package org.mild.common.mybatis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 基础字段枚举
 *
 * @author 史偕成
 * @date 2024/05/25 09:29
 **/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BaseFieldEnums {
    /**
     * 创建时间
     */
    CREATE_TIME("createTime"),
    UPDATE_TIME("updateTime"),
    CREATE_USER("createBy"),
    UPDATE_USER("updateBy"),
    DELETED("deleted");

    private String field;

}
