package org.mild.system.manage.mapstruct;

import org.mapstruct.Mapper;
import org.mild.system.api.dto.menu.OperaMenuDTO;
import org.mild.system.api.vo.menu.MenuVO;
import org.mild.system.domain.pojo.Menu;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Mapper(componentModel = "spring")
public interface MenuConvert {

    /**
     * Dto -> po
     *
     * @param operaMenuDTO 操作菜单对象
     * @return VO
     */
    Menu operaToMenu(OperaMenuDTO operaMenuDTO);

    /**
     * po -> Vo
     * @param menu
     * @return
     */
    MenuVO queryToMenu(Menu menu);
}
