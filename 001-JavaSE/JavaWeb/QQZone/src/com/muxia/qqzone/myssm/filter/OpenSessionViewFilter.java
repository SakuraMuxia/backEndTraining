package com.muxia.qqzone.myssm.filter;

/*
* 这个过滤器作用是 管理事务的回滚
* */


import com.muxia.qqzone.myssm.transaction.TransactionManager;
import com.muxia.qqzone.myssm.utils.ConnUtil;

import javax.servlet.*;

public class OpenSessionViewFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain){
        try {
            // 开启事务
            TransactionManager.begin();
            // 放行
            chain.doFilter(req,resp);
            // 提交事务
            TransactionManager.submit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            TransactionManager.rollback();
        }finally {
            ConnUtil.closeConn();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
