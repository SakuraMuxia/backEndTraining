package com.fruit.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends GenericServlet {
    // 当请求到来时，service会被自动调用(通过tomcat利用反射技术进行调用)
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 1. 设置响应类型
        // 这里告诉浏览器返回的是文本内容，编码为UTF-8，避免中文乱码
        res.setContentType("text/html;charset=UTF-8");

        // 2 获取请求参数
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        // 3. 打印到控制台（便于调试）
        System.out.println("账号密码分别为" + uname + pwd);

        // 4. 获取输出流，向浏览器返回响应
        PrintWriter out = res.getWriter();

        // 5. 返回简单HTML响应
        if ("admin".equals(uname) && "123456".equals(pwd)) {
            out.println("<h1>登录成功，欢迎：" + uname + "</h1>");
        } else {
            out.println("<h1>登录失败，请检查用户名或密码</h1>");
        }

        // 6. 关闭流
        out.close();
    }
}
