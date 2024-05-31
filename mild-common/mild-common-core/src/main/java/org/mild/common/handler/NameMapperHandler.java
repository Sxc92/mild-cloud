package org.mild.common.handler;

import cn.hutool.core.util.StrUtil;
import org.mild.common.constant.SpecialCharConstant;
import org.mild.common.utils.KeyPrefixUtils;
import org.redisson.api.NameMapper;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */

public class NameMapperHandler implements NameMapper {

    private final String keyPrefix;

    public NameMapperHandler(String keyPrefix) {
        //前缀为空 则返回空前缀
        this.keyPrefix = StrUtil.isBlank(keyPrefix) ? "" :
                keyPrefix.replace(SpecialCharConstant.DASH, SpecialCharConstant.COLON)
                        + SpecialCharConstant.COLON;
    }

    @Override
    public String map(String name) {
        return KeyPrefixUtils.map(name, this.keyPrefix);
    }

    @Override
    public String unmap(String name) {
        return KeyPrefixUtils.unmap(name, this.keyPrefix);
    }
}
