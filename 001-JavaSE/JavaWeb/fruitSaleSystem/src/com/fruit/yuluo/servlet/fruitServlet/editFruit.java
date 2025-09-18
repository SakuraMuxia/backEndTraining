package com.fruit.yuluo.servlet.fruitServlet;

import com.fruit.yuluo.dao.FruitDao;
import com.fruit.yuluo.dao.impl.FruitDaoImpl;
import com.fruit.yuluo.pojo.Fruit;
import com.fruit.yuluo.servlet.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editFruit extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求传来的参数
        String idStr = req.getParameter("id");
        // 判断条件,不能为空且不能不传
        if(idStr !=null && !"".equals(idStr)){
            // 转为包装类,同时强转为Integer类
            Integer id = Integer.parseInt(idStr);
            // 创建dao实例
            FruitDao fruitDao = new FruitDaoImpl();
            // 获取实例
            Fruit fruit = fruitDao.getFruitById(id);
            // 将fruit放在request请求域中
            req.setAttribute("fruit",fruit);
            // System.out.println("fruit = " + fruit);
            // 转发到编辑页面
            super.processTemplate("editFruit",req,resp);
        }
    }
}
