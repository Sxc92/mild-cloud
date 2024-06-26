package org.mild.system.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.mild.system.domain.mapper.UserMapper;
import org.mild.system.domain.pojo.User;
import org.mild.system.domain.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 史偕成
 * @date 2024/05/26 22:25
 **/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
