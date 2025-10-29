package com.muxia.bookstore.myssm.filter;

import com.muxia.bookstore.myssm.utils.StringUtils;
import javax.servlet.*;
import java.io.IOException;

/*
* 这个过滤器是为了统一编码
* */

public class CharacterEncodingFilter implements Filter {
    private final String ENCODING_KEY = "encoding";
    // 设置一个静态常量
    private String defaultEncoding = "UTF-8";

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 从web.xml读取初始化参数
        String encoding = config.getInitParameter(ENCODING_KEY);
        // 判断,如果没有配置则为 UTF-8
        if (StringUtils.isNotEmpty(encoding)){
            defaultEncoding = encoding;
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 设置 统一编码
        req.setCharacterEncoding(defaultEncoding);
        // 放行
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
