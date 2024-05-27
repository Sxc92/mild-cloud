package org.mild.system.manage;

import org.mild.system.api.vo.AccountVO;

/**
 * @author 史偕成
 * @date 2024/05/27 07:58
 **/
public interface AccountManage {

    AccountVO getAccount(String id);
}
