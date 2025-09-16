package com.fruit.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MarinServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 强转为HttpServletRequest
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;

        // 获取context属性
        ServletContext context = httpReq.getServletContext();
        Object uname = context.getAttribute("uname");
        System.out.println("uname = " + uname);
    }
}
