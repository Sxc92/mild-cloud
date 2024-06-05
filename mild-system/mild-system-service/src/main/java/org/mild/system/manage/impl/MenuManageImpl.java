package org.mild.system.manage.impl;

import lombok.extern.slf4j.Slf4j;
import org.mild.system.api.dto.menu.OperaMenuDTO;
import org.mild.system.api.vo.menu.MenuVO;
import org.mild.system.manage.MenuManage;
import org.springframework.stereotype.Service;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Slf4j
@Service
public class MenuManageImpl implements MenuManage {
    @Override
    public boolean saveOrModify(OperaMenuDTO operaMenuDTO) {
        return false;
    }

    @Override
    public boolean deleteMenu(String menuName) {
        return false;
    }

    @Override
    public MenuVO queryMenu(String menuName) {
        return null;
    }
}
