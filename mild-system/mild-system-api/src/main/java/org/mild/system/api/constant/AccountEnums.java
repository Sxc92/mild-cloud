package org.mild.system.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账户枚举
 *
 * @author 史偕成
 * @date 2024/05/20 22:04
 **/
public interface AccountEnums {

    @Getter
    @AllArgsConstructor
    enum AccountStatus {
        /**
         * 0:正常、1:停用
         */
        ENABLE(0),

        DISABLE(1);
        private final int code;
    }


    /**
     * 账户类型枚举
     */
    @Getter
    @AllArgsConstructor
    enum AccountType {
        /**
         * 内部账户
         */
        INSIDE(0),

        /**
         * 客户账户
         */
        CUSTOMER(1),

        /**
         * 供应商账户
         */
        SUPPLIER(2);
        private final int code;
    }

    /**
     * 账户锁定状态
     */
    @Getter
    @AllArgsConstructor
    enum AccountLock {
        /**
         * 账号锁定状态 0:锁定、1:未锁定
         */
        LOCK(0),

        UN_LOCK(1);

        private final int code;
    }

    @Getter
    @AllArgsConstructor
    enum AccountExpired {
        /**
         * 账号锁定状态 0:锁定、1:未锁定
         */
        EXPIRED(0),

        UN_EXPIRED(1);

        private final int code;
    }
}
