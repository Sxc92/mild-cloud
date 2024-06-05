package org.mild.system.api.dto.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.web.dto.QueryBaseDTO;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryMenuDTO extends QueryBaseDTO {

    /**
     * 名称
     */
    private String name;


}
