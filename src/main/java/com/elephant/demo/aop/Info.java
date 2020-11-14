package com.elephant.demo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xyq
 * @描述：
 * @创建时间：2020/11/14 14:54
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Info {
    public String operationType() default "";
    public String doWhat() default "";
}
