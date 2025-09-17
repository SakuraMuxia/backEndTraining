package com.fruit.yuluo.servlet.firstServlet;

import com.fruit.yuluo.servlet.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class firstServlet extends ViewBaseServlet {

    // 重写 HttpServlet 方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 之前渲染方式：request.getRequestDispatcher("index.html").forward(request,response);
        // 现在使用 thymeleaf 渲染：super.processTemplate("逻辑视图名称",request,response);
        // 物理视图名称  =  视图前缀 + 逻辑视图名称 + 视图后缀
        // /page01.html=   /          page01        .html
        super.processTemplate("page1",req,resp);
    }
}
