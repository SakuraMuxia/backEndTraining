package com.muxia.bookstore.myssm.ioc;

// Bean工厂，给一个id返回一个JavaBean实例，用于解耦合，通过id获取Bean对象
public interface BeanFactory {
    Object getBean(String id);
}
