package org.mild.common.mybatis.handle;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.mild.common.mybatis.enums.BaseFieldEnums;
import org.springframework.util.ClassUtils;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * @author 史偕成
 * @Description Mybatis plus 自动填充
 * @date 2024/05/24 17:43
 **/
@Slf4j
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        fillValIfNullByName(BaseFieldEnums.CREATE_TIME.getField(), LocalDateTime.now(), metaObject);
        fillValIfNullByName(BaseFieldEnums.UPDATE_TIME.getField(), LocalDateTime.now(), metaObject);
        // TODO 等待后面认证鉴权做了 进行添加
        fillValIfNullByName(BaseFieldEnums.CREATE_USER.getField(), "", metaObject);
        fillValIfNullByName(BaseFieldEnums.UPDATE_USER.getField(), "", metaObject);
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        fillValIfNullByName(BaseFieldEnums.UPDATE_TIME.getField(), LocalDateTime.now(), metaObject);
        fillValIfNullByName(BaseFieldEnums.UPDATE_USER.getField(), "", metaObject);
    }

    /**
     * 自动填充
     *
     * @param fieldName
     * @param fieldVal
     * @param metaObject
     */
    private void fillValIfNullByName(String fieldName, Object fieldVal, MetaObject metaObject) {
        if (fieldVal == null) {
            return;
        }
        if (!metaObject.hasSetter(fieldName)) {
            return;
        }
        // 2. 如果用户有手动设置的值
        Object userSetValue = metaObject.getValue(fieldName);
        String setValueStr = StrUtil.str(userSetValue, Charset.defaultCharset());
        if (StrUtil.isNotBlank(setValueStr)) {
            return;
        }
        // 3. field 类型相同时设置
        Class<?> getterType = metaObject.getGetterType(fieldName);
        if (ClassUtils.isAssignableValue(getterType, fieldVal)) {
            metaObject.setValue(fieldName, fieldVal);
        }
    }
}
