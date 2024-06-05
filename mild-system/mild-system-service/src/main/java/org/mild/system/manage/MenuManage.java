package org.mild.system.manage;

import org.mild.system.api.dto.menu.OperaMenuDTO;
import org.mild.system.api.vo.menu.MenuVO;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
public interface MenuManage {

    boolean saveOrModify(OperaMenuDTO operaMenuDTO);

    boolean deleteMenu(String menuName);

    MenuVO queryMenu(String menuName);


}
