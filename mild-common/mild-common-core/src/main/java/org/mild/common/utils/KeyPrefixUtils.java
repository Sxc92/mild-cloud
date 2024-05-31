package org.mild.common.utils;

import cn.hutool.core.util.StrUtil;
import org.redisson.api.NameMapper;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
public class KeyPrefixUtils {

    /**
     * 增加前缀
     */
    public static String map(String name, String keyPrefix) {
        if (StrUtil.isBlank(name)) {
            return null;
        }
        if (StrUtil.isNotBlank(keyPrefix) && !name.startsWith(keyPrefix)) {
            return keyPrefix + name;
        }
        return name;
    }

    /**
     * 去除前缀
     */
    public static String unmap(String name, String keyPrefix) {
        if (StrUtil.isBlank(name)) {
            return null;
        }
        if (StrUtil.isNotBlank(keyPrefix) && name.startsWith(keyPrefix)) {
            return name.substring(keyPrefix.length());
        }
        return name;
    }
}
