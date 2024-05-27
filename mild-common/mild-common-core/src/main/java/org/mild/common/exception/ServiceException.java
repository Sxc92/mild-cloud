package org.mild.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.mild.common.exception.errorEnums.ErrorEnum;

/**
 * @author 史偕成
 * @date 2024/05/19 22:29
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private ErrorEnum errorEnum;

}
