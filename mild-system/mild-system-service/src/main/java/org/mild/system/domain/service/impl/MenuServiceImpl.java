package org.mild.system.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mild.system.domain.mapper.MenuMapper;
import org.mild.system.domain.pojo.Menu;
import org.mild.system.domain.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * @author 史偕成
 * @date 2024/06/03 08:02
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
