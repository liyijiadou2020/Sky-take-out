package com.sky.annotation;
import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义的注解，用于标识某个方法需要进行功能字段的自动填充处理
 *
 * @author Li Yijia
 * @date 2024/4/12
 */
@Target(ElementType.METHOD) // 只能加在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    /**
     * 指定数据库操作类型：UPDATE, INSERT
     * @return
     */
    OperationType value();
}
