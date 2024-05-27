package org.mild.system.controller;

import lombok.RequiredArgsConstructor;
import org.mild.common.domain.Result;
import org.mild.system.api.vo.AccountVO;
import org.mild.system.manage.AccountManage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 史偕成
 * @date 2024/05/26 22:28
 **/

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountManage accountManage;

    @GetMapping("/{id}")
    public Result<AccountVO> queryById(@PathVariable String id) {
        return Result.success(accountManage.getAccount(id));
    }
}
