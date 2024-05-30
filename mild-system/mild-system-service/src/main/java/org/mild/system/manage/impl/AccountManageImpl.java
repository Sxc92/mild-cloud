package org.mild.system.manage.impl;

import lombok.RequiredArgsConstructor;
import org.mild.common.exception.ServiceException;
import org.mild.system.api.constant.ExceptionEnums;
import org.mild.system.api.vo.AccountVO;
import org.mild.system.domain.pojo.Account;
import org.mild.system.domain.service.AccountService;
import org.mild.system.manage.AccountManage;
import org.mild.system.manage.mapstruct.AccountConvert;
import org.springframework.stereotype.Service;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Service
@RequiredArgsConstructor
public class AccountManageImpl implements AccountManage {

    private final AccountService accountService;

    private final AccountConvert accountConvert;

    @Override
    public AccountVO getAccount(String id) {
//        throw new ServiceException(ExceptionEnums.ACCOUNT_PASSWORD_ERROR);
        Account account = accountService.getById(id);
        String userName = account.getUserName();
        System.out.println(userName);
        AccountVO accountVO = accountConvert.toAccountVO(account);
        System.out.println(accountVO.getUserName());
        return null;
    }
}
