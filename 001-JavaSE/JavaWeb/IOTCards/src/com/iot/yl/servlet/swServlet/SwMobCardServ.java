package com.iot.yl.servlet.swServlet;

import com.iot.yl.dao.SwDao;
import com.iot.yl.dao.impl.SwDaoImpl;
import com.iot.yl.pojo.SwCard;
import com.iot.yl.servlet.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SwMobCardServ extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 新建dao
        SwDao swDao = new SwDaoImpl();
        // 执行dao操作
        List<SwCard> Cards = swDao.getSwMobCards();
        Integer totals = swDao.getSwMobCardNum();
        // for (CoolerCard coolerCard : coolerCards) {
        //     System.out.println("coolerCard = " + coolerCard);
        // }
        // 把数据存放在请求域中
        req.setAttribute("Cards",Cards);
        req.setAttribute("totals",totals);
        req.setAttribute("cardType","开关移动卡");
        processTemplate("swmob",req,resp);
    }
}
