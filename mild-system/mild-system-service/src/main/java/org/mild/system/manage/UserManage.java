package org.mild.system.manage;

import org.mild.system.api.dto.user.QueryUserDTO;
import org.mild.system.api.vo.user.UserVO;

/**
 * @author 史偕成
 * @date 2024/05/27 07:58
 **/
public interface UserManage {


    /**
     * 根据账号Id 获取账户详情
     *
     * @param queryUserDTO 用户请求参数
     * @return AccountVO
     */
    UserVO detail(QueryUserDTO queryUserDTO);

    boolean saveOrUpdate();
}
