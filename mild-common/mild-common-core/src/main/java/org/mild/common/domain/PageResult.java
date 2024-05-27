package org.mild.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.mild.common.constant.CommonConstant;
import org.mild.common.constant.SystemConstant;

import java.io.Serializable;
import java.util.List;

/**
 * @author 史偕成
 * @date 2024/05/19 21:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> extends Result<T> {


    /**
     * 总条数
     */
    private long total;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 数据
     */
    private List<T> records;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;


    /**
     * 创建一个分页结果对象。
     *
     * @param records 分页查询结果中的记录列表。
     * @param total   总记录数。
     * @param pages   总页数。
     * @param <T>     记录类型。
     * @return 返回一个初始化好的PageResult对象。
     */
    public static <T> PageResult<T> of(List<T> records, long total, long pages) {
        return new PageResult<>(total, pages, records, CommonConstant.DEFAULT_SUCCESS, CommonConstant.DEFAULT_SUCCESS_MSG);
    }


    /**
     * 创建一个分页结果对象。
     *
     * @param <T> 记录类型。
     * @return 返回一个初始化好的PageResult对象。
     */
    public static <T> PageResult<T> fail() {
        return new PageResult<>(0L, 0L, List.of(),
                CommonConstant.DEFAULT_ERROR,
                CommonConstant.DEFAULT_ERROR_MSG);
    }
}
