package com.muxia.bookstore.myssm.utils;


import com.muxia.bookstore.myssm.ioc.BeanFactory;

import javax.servlet.ServletContext;

public class IocUtil {
    // 定义一个静态常量
    private static final String IOC_CONTAINER_KEY = "IOC_CONTAINER_KEY";

    // 定义方法-通过 application 作用域获取 beanFactory 对象
    public static BeanFactory getBeanFactory(ServletContext servletContext){
        return (BeanFactory) servletContext.getAttribute(IOC_CONTAINER_KEY);
    }
}
