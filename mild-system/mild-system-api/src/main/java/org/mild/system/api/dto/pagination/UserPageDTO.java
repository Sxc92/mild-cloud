package org.mild.system.api.dto.pagination;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.web.dto.QueryPage;

/**
 * @author 史偕成
 * @date 2024/05/26 22:32
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPageDTO extends QueryPage {

    private String userName;

    /**
     *
     */
    private Integer type;
}
