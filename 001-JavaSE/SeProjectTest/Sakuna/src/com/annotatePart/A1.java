package com.annotatePart;


import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Documented
@Deprecated
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD}) // 修饰范围为类，属性，方法
public @interface A1 {

}
