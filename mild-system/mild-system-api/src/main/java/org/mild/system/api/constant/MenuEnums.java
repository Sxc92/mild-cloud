package org.mild.system.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
public interface MenuEnums {
    /**
     * 菜单类型
     */
    @Getter
    @AllArgsConstructor
    enum MenuType {
        /**
         * 目录
         */
        DIR(0),

        /**
         * 菜单
         */
        MENU(1),

        /**
         * 按钮
         */
        BUTTON(2);

        private final int value;

        public int getValue() {
            return value;
        }
    }

    /**
     * 是否可见
     */
    @Getter
    @AllArgsConstructor
    enum MenuVisible {
        /**
         * 显示
         */
        VISIBLE(0),

        /**
         * 隐藏
         */
        HIDDEN(1);

        private final int value;

        public int getValue() {
            return value;
        }
    }
}
