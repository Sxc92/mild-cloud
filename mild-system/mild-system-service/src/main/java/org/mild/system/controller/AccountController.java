package org.mild.system.controller;

import lombok.RequiredArgsConstructor;
import org.mild.system.manage.UserManage;
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

    private final UserManage userManage;

//    @GetMapping("/{id}")
//    public Result<UserVO> queryById(@PathVariable String id) {
//        return Result.success(userManage.getAccount(id));
//    }
}
