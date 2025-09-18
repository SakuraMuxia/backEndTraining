package com.fruit.yuluo.servlet.fruitServlet;

import com.fruit.yuluo.dao.FruitDao;
import com.fruit.yuluo.dao.impl.FruitDaoImpl;
import com.fruit.yuluo.servlet.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class delFruit extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解析请求中的id
        Integer id = Integer.parseInt(req.getParameter("id"));
        // 创建fruitDao对象
        FruitDao fruitDao = new FruitDaoImpl();
        // 调用删除
        fruitDao.delFruit(id);
        // 重定向到首页
        resp.sendRedirect("fruitList");
    }
}
