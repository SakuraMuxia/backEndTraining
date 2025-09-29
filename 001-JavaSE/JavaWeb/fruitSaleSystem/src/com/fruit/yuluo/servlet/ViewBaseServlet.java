package com.fruit.yuluo.servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewBaseServlet extends HttpServlet {
    private TemplateEngine templateEngine;

    //抽离的请求统一DispatcherServlet 这里的init方法不再被调用了，
    @Override
    public void init() throws ServletException {
        // 初始化 Thymeleaf 模板解析器，这里用于解析Web.xml配置文件
        ServletContextTemplateResolver resolver =
                new ServletContextTemplateResolver(this.getServletContext());
        // 设置前缀和后缀
        resolver.setPrefix(getServletContext().getInitParameter("view-prefix"));
        resolver.setSuffix(getServletContext().getInitParameter("view-suffix"));
        resolver.setCharacterEncoding("utf-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }
    // 渲染模版
    protected void processTemplate(String templateName,
                                   HttpServletRequest req,
                                   HttpServletResponse resp) throws IOException {
        // 设置响应类型为 HTML，字符集 UTF-8
        resp.setContentType("text/html;charset=UTF-8");
        // 构建 Thymeleaf 的上下文对象（包含 request、response、servletContext 等）
        WebContext webContext = new WebContext(req, resp, getServletContext());
        // 调用 Thymeleaf 的模板引擎，把指定模板渲染为 HTML 并写入响应流
        templateEngine.process(templateName, webContext, resp.getWriter());
    }
}


