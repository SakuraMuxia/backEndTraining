package com.fruit.yuluo.controller;

import com.fruit.yuluo.pojo.Fruit;
import com.fruit.yuluo.service.FruitService;
import com.fruit.yuluo.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

public class FruitController{
    // 定义一个静态常量
    private static final String REQ_DO = "fruit.do";
    // 新增一个Service类 (使用Ioc工厂类获取实例对象)
    // private FruitService fruitService = new FruitServiceImpl();
    /* 在 bean.xml 中添加了 配置
    <bean id="fruit" class="com.fruit.yuluo.controller.FruitController">
        <property name="fruitService" ref="fruitService"></property>
    </bean>
    * */
    private FruitService fruitService;

    // list方法
    protected String list(HttpServletRequest req,HttpSession session,String operate,String keyword,Integer pageNo,Integer pageSize){
        if(StringUtils.isEmpty(keyword)){
            keyword = "" ;
        }
        if (pageNo == null){
            pageNo = 1;
        }
        if (pageSize == null){
            pageSize = 5;
        }
        // 搜索逻辑判断，非空且是search操作
        if(StringUtils.isNotEmpty(operate) && "search".equals(operate)){
            session.setAttribute("keyword",keyword);
        }else{
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj != null){
                keyword = (String)keywordObj;
            }
        }

        // 查询数据库，使用service层实现
        List<Fruit> fruitList = fruitService.getFruitList(keyword, pageNo, pageSize);
        Integer totalNum = fruitService.getTotalNum(keyword);
        Integer totalPageNum = fruitService.getTotalPageNum(keyword, pageSize);

        // 判断pageNo和pageSize合法范围
        if (pageNo <=0){
            pageNo = 1;
        }
        if (pageNo >= totalPageNum){
            pageNo = totalPageNum;
        }

        // 不必放 session，避免并发和数据混乱
        req.setAttribute("fruitList",fruitList);
        req.setAttribute("pageCount",totalPageNum);
        req.setAttribute("totalCount",totalNum);

        //将pageNo保存到session作用域
        req.setAttribute("pageNo",pageNo);
        req.setAttribute("pageSize",pageSize);

        // 使用thymeleaf渲染,渲染fruitList页面,在ViewBaseServlet初始化时配置了，读取web.xml中的配置
        // super.processTemplate("fruitList",req,resp);
        // 使用中央Servlet控制器处理视图转发，跳转到 fruitList.html 页面
        return "fruitList";
    }

    // add 方法
    protected String add(String fname,String price,Integer count,String remark){
        // 转为大数
        BigDecimal bigPrice = new BigDecimal(price.trim());
        // 调用service
        Fruit fruit = new Fruit(fname,bigPrice,count,remark);
        fruitService.addFruit(fruit);
        // 重定向到列表请求
        // resp.sendRedirect(REQ_DO);
        // 使用中央控制器处理题图
        return "redirect:" + REQ_DO;
    }

    // edit 方法
    protected String edit(HttpServletRequest req,Integer id){
        // 判断条件,不能为空且不能不传
        if(id != null){
            // 使用service层
            Fruit fruit = fruitService.getFruitById(id);
            // 将fruit放在request请求域中
            req.setAttribute("fruit",fruit);
            // System.out.println("fruit = " + fruit);
            // 跳转到 editFruit.html 页面
            return "editFruit";
        }
        return null;
    }

    // update 方法
    protected String update(Integer id,String fname,String price,Integer count,String remark){

        // 转为大数
        BigDecimal bigPrice = new BigDecimal(price.trim());
        // 创建水果对象
        Fruit fruit = new Fruit(id,fname,bigPrice,count,remark);
        // 更新数据库数据
        fruitService.updateFruit(fruit);
        // 转发到 水果列表页面，
        // processTemplate("fruitList",req,resp);
        // 重定向 列表请求
        return "redirect:" + REQ_DO;
    }

    // del 方法
    protected String del(Integer id){
        // 调用删除
        fruitService.delFruit(id);
        // 重定向 到列表请求
        return "redirect:" + REQ_DO;
    }
}
