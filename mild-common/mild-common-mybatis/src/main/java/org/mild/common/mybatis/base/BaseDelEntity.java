package org.mild.common.mybatis.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 史偕成
 * @date 2024/05/24 17:27
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseDelEntity extends BaseCreateEntity {

    /**
     * 软删标识
     */
    @TableLogic(value = "0", delval = "1")
    private int delFlag;
}
