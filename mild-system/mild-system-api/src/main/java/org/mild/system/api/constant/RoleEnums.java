package org.mild.system.api.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author 史偕成
 * @date 2024/06/01 13:29
 **/
public interface RoleEnums {

    @Getter
    @AllArgsConstructor
    enum RoleStatus {
        /**
         * 启用
         */
        ENABLE(0),
        DISABLE(1);
        public final int code;
    }


}
