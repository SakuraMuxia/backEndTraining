package com.iot.yl.servlet.coolerServlet;

import com.iot.yl.dao.CoolerDao;
import com.iot.yl.dao.impl.CoolerDaoImpl;
import com.iot.yl.pojo.CoolerCard;
import com.iot.yl.servlet.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CoolTeleCardServ extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 新建dao
        CoolerDao coolerDao = new CoolerDaoImpl();
        List<CoolerCard> coolerCards = coolerDao.getCoolTeleCards();
        Integer totals = coolerDao.getCoolTeleCardNum();
        // for (CoolerCard coolerCard : coolerCards) {
        //     System.out.println("coolerCard = " + coolerCard);
        // }
        // 把数据存放在请求域中
        req.setAttribute("teleCards",coolerCards);
        req.setAttribute("totals",totals);
        req.setAttribute("cardType","降温电信卡");
        processTemplate("cooltel",req,resp);
    }
}
