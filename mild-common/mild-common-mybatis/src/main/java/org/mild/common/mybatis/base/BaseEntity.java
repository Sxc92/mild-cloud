package org.mild.common.mybatis.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 史偕成
 * @date 2024/05/20 22:14
 **/
@Data
public class BaseEntity implements Serializable {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
}
