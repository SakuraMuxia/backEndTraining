package com.fruit.yuluo.ioc;

// Bean工厂，给一个id返回一个JavaBean实例
public interface BeanFactory {
    Object getBean(String id);
}
