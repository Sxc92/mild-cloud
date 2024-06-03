package org.mild.system.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mild.system.domain.pojo.User;

/**
 * @author 史偕成
 * @date 2024/05/26 22:23
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
