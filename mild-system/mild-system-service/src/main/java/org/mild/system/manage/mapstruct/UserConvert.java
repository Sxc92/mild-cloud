package org.mild.system.manage.mapstruct;

import org.mapstruct.Mapper;
import org.mild.system.api.vo.UserVO;
import org.mild.system.domain.pojo.User;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Mapper(componentModel = "spring")
public interface UserConvert {
    /**
     * PO -> VO
     *
     * @param user
     * @return VO
     */
    UserVO toAccountVO(User user);
}
