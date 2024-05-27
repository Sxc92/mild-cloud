package org.mild.system.manage.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mild.system.api.vo.AccountVO;
import org.mild.system.domain.pojo.Account;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Mapper(componentModel = "spring")
public interface AccountConvert {
    /**
     * PO -> VO
     *
     * @param account
     * @return VO
     */
    @Mapping(source = "userName", target = "userName")
    AccountVO toAccountVO(Account account);
}
