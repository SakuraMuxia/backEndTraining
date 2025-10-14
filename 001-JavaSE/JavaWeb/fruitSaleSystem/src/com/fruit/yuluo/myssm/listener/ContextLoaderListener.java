package com.fruit.yuluo.myssm.listener;

import com.fruit.yuluo.myssm.ioc.BeanFactory;
import com.fruit.yuluo.myssm.ioc.impl.ClassPathXmlApplicationContext;
import com.fruit.yuluo.myssm.utils.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 声明 beanFactory 对象
        BeanFactory beanFactory = null;
        // 获取 context 对象
        ServletContext ctx = sce.getServletContext();
        // 获取 初始化参数配置
        String contextConfigLocation = ctx.getInitParameter("contextConfigLocation");
        // 创建Ioc容器
        if (StringUtils.isNotEmpty(contextConfigLocation)){
            beanFactory = new ClassPathXmlApplicationContext(contextConfigLocation);
        }else{
            beanFactory = new ClassPathXmlApplicationContext();
        }
        // 放在 application 作用域中
        ctx.setAttribute("IOC_CONTAINER_KEY",beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁...");
    }
}
