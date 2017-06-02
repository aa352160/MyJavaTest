package com.jh352160.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by pcdalao on 2016/12/21.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface run_methodInfo {
    String name() default "long";
    String data();
    int id() default 365;
}

