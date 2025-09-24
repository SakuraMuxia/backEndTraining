package com.fruit.yuluo.servlet.fruitServlet;

import com.fruit.yuluo.dao.FruitDao;
import com.fruit.yuluo.dao.impl.FruitDaoImpl;
import com.fruit.yuluo.pojo.Fruit;
import com.fruit.yuluo.servlet.ViewBaseServlet;
import com.fruit.yuluo.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/fruit.do")
public class fruitServlet extends ViewBaseServlet {
    // 定义一个静态常量
    private static final String REQ_DO = "fruit.do";

    // 请求进来的所有入口
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        // 从请求参数中获取一个叫oper的值。这个值和将来要执行的方法名对应
        // 如果oper=list , 那么我们就调用list方法
        // 如果oper=update , 那么我们就调用update方法
        String oper = req.getParameter("oper");
        // 空判断
        if(StringUtils.isEmpty(oper)){
            oper = "list" ;
        }
        // 方法调用
        // 方式1：使用switch case 多了不方便
        // switch(oper){
        //     case "list":
        //         list(req, resp);
        //         break;
        //     ...
        //     default:
        //         throw new RuntimeException("没有找到"+oper+"对应的方法！");
        // }

        // 方式2：使用反射方式

        try {
            // 获取此类实例的方法
            Method method = this.getClass().getDeclaredMethod(oper, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // list方法
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 定义关键字
        String keyword = "";
        // 定义前端的操作标记
        String operate = req.getParameter("operate");
        // 定义前端页码和每页大小
        Integer pageNo = 1;
        Integer pageSize = 5;
        Integer pageCount = 0;
        // 创建dao实例
        FruitDao fruitDao = new FruitDaoImpl();
        // 获取session对象
        HttpSession session = req.getSession();
        // 搜索操作
        if ("search".equals(operate)){
            // 获取请求参数中关键字
            String keywordStr = req.getParameter("keyword");
            if (StringUtils.isNotEmpty(keywordStr)){
                keyword = keywordStr;
            }
            // 把关键字存储到session中,再会话中始终存在
            session.setAttribute("keyword",keyword);
        }else{ // 下一页操作
            Object keywordObj = session.getAttribute("keyword");
            // 如果不为空
            if (keywordObj != null){
                // 强转为String类型，并复制给keyword
                keyword = (String) keywordObj;
            }
        }
        // 获取前端传来的页码
        String pageNoStr = req.getParameter("pageNo");
        String pageSizeStr = req.getParameter("pageSize");
        // 判断pageNoStr和pageSizeStr 不能为空且不能为null
        if (StringUtils.isNotEmpty(pageNoStr)){
            pageNo = Integer.parseInt(pageNoStr);
        }
        if (StringUtils.isNotEmpty(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        // 查询数据库
        List<Fruit> fruitList = fruitDao.getFruitList(keyword, pageNo, pageSize);
        Integer totalCount = fruitDao.getTotalCount(keyword);
        // 计算总页数
        pageCount = (totalCount + pageSize -1 ) / pageSize;
        // 判断pageNo和pageSize合法范围
        if (pageNo <=0){
            pageNo = 1;
        }
        if (pageNo >= pageCount){
            pageNo = pageCount;
        }
        // 不必放 session，避免并发和数据混乱
        req.setAttribute("fruitList",fruitList);
        req.setAttribute("pageCount",pageCount);
        req.setAttribute("totalCount",totalCount);
        //将pageNo保存到session作用域
        req.setAttribute("pageNo",pageNo);
        req.setAttribute("pageSize",pageSize);
        // 使用thymeleaf渲染,渲染fruitList页面,在ViewBaseServlet初始化时配置了，读取web.xml中的配置
        super.processTemplate("fruitList",req,resp);
    }

    // add 方法
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String fname = req.getParameter("fname");
        String price = req.getParameter("price");
        // 转为大数
        BigDecimal bigPrice = new BigDecimal(price.trim());
        Integer fcount = Integer.parseInt(req.getParameter("count"));
        String remark = req.getParameter("remark");
        // 调用dao方法
        Fruit fruit = new Fruit(fname,bigPrice,fcount,remark);
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.addFruit(fruit);
        // 重定向到列表请求
        resp.sendRedirect(REQ_DO);
    }

    // edit 方法
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    // update 方法
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        // 重定向 列表请求
        resp.sendRedirect(REQ_DO);
    }

    // del 方法
    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解析请求中的id
        Integer id = Integer.parseInt(req.getParameter("id"));
        // 创建fruitDao对象
        FruitDao fruitDao = new FruitDaoImpl();
        // 调用删除
        fruitDao.delFruit(id);
        // 重定向 到列表请求
        resp.sendRedirect(REQ_DO);
    }
}
