package com.fruit.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
// 模拟Session和Http无状态
public class AquaServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 强转为HttpServletRequest
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;

        // 向request作用域中设置属性
        ServletContext context = httpReq.getServletContext();
        // 设置属性
        context.setAttribute("uname","hanser Is My Angle");
        // 重定向到 marin请求
        httpRes.sendRedirect("marin");
    }
}
