package org.mild.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Locale;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Getter
@AllArgsConstructor
public enum RedisModeEnums {
    /**
     * 单机模式
     */
    SINGLE,

    /**
     * 集群模式
     */
    CLUSTER;

    /**
     * @param name 类型
     * @return
     */
    public static RedisModeEnums get(String name) {
        for (RedisModeEnums value : values()) {
            if (value.name().toLowerCase(Locale.ROOT).equals(name)) {
                return value;
            }
        }
        return null;
    }
}
