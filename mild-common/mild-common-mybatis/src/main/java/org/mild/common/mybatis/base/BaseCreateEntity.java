package org.mild.common.mybatis.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 史偕成
 * @date 2024/05/24 17:18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseCreateEntity extends BaseEntity {


    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
}
