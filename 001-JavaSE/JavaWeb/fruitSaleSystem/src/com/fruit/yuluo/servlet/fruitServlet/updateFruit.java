package com.fruit.yuluo.servlet.fruitServlet;

import com.fruit.yuluo.dao.FruitDao;
import com.fruit.yuluo.dao.impl.FruitDaoImpl;
import com.fruit.yuluo.pojo.Fruit;
import com.fruit.yuluo.servlet.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class updateFruit extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的编码，防止乱码
        req.setCharacterEncoding("utf-8");
        // 获取Post请求中，请求体中的数据
        String fname = req.getParameter("fname");
        String price = req.getParameter("price");
        // 转为大数
        BigDecimal bigPrice = new BigDecimal(price.trim());
        Integer count = Integer.parseInt(req.getParameter("count"));
        String remark = req.getParameter("remark");
        Integer id = Integer.parseInt(req.getParameter("id"));
        // 创建Dao对象
        FruitDao fruitDao = new FruitDaoImpl();
        // 创建水果对象
        Fruit fruit = new Fruit(id,fname,bigPrice,count,remark);
        // 更新数据库数据
        fruitDao.updateFruit(fruit);
        // 转发到 水果列表页面，
        // processTemplate("fruitList",req,resp);
        // 重定向 水果列表页面，重新再次获取请求
        resp.sendRedirect("fruitList");
    }
}
