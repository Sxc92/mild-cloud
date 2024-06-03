package org.mild.system.manage.impl;

import lombok.RequiredArgsConstructor;
import org.mild.common.utils.RedisUtils;
import org.mild.system.api.dto.user.UserSearchDTO;
import org.mild.system.api.vo.UserVO;
import org.mild.system.domain.pojo.User;
import org.mild.system.domain.service.UserService;
import org.mild.system.manage.UserManage;
import org.mild.system.manage.mapstruct.UserConvert;
import org.springframework.stereotype.Service;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Service
@RequiredArgsConstructor
public class UserManageImpl implements UserManage {

    private final UserService userService;

    private final UserConvert userConvert;

    @Override
    public UserVO detail(UserSearchDTO userSearchDTO) {
        return null;
    }

    @Override
    public boolean saveOrUpdate() {
        return false;
    }


//    @Override
//    public UserVO getAccount(String id) {
////        throw new ServiceException(ExceptionEnums.ACCOUNT_PASSWORD_ERROR);
//        User user = userService.getById(id);
//        String userName = user.getUserName();
//        System.out.println(userName);
//        UserVO userVO = userConvert.toAccountVO(user);
//        RedisUtils.set(userVO.getId(), userVO);
//        return userVO;
//    }
}
