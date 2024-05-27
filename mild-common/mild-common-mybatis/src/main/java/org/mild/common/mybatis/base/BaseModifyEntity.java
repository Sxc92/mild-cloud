package org.mild.common.mybatis.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author 史偕成
 * @date 2024/05/24 17:28
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseModifyEntity extends BaseDelEntity {

    /**
     * 乐观锁版本号
     */
    @Version
    private Integer revision;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
