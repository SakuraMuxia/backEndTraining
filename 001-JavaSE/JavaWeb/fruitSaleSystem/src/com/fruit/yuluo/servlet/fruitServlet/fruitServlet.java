package com.fruit.yuluo.servlet.fruitServlet;

import com.fruit.yuluo.dao.FruitDao;
import com.fruit.yuluo.dao.impl.FruitDaoImpl;
import com.fruit.yuluo.pojo.Fruit;
import com.fruit.yuluo.servlet.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class fruitServlet extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建dao实例
        FruitDao fruitDao = new FruitDaoImpl();
        // 调用查询方法
        List<Fruit> fruitList = fruitDao.getFruitList();

        // 打印查询到的数据
        // for (Fruit fruit : fruitList) {
        //     System.out.println("fruit = " + fruit);
        // }

        // 保存到session中
        HttpSession session = req.getSession();
        // 设置属性
        session.setAttribute("fruitList",fruitList);
        // 使用thymeleaf渲染
        super.processTemplate("fruitList",req,resp);

    }
}
