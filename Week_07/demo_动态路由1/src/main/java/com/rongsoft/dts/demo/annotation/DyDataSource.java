package com.rongsoft.dts.demo.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DyDataSource {
    String value();
    boolean needRouter() default true ;
}
