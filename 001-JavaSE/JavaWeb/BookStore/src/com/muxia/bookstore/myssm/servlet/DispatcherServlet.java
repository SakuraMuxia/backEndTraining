package com.muxia.bookstore.myssm.servlet;

import com.muxia.bookstore.myssm.ioc.BeanFactory;
import com.muxia.bookstore.myssm.utils.IocUtil;
import com.muxia.bookstore.myssm.utils.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {

    private BeanFactory beanFactory;
    // 创建 bean 实例
    // private BeanFactory beanFactory = new ClassPathXmlApplicationContext();
    // 在 Listener 中创建实例
    // 在 application 作用域中 获取 bean实例


    @Override
    public void init() throws ServletException {
        super.init();//这句话不能省略。因为父类的初始化方法中也有操作，需要创建模板引擎对象
        ServletContext ctx = this.getServletContext();
        beanFactory = IocUtil.getBeanFactory(ctx);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 统一设置请求头
        // req.setCharacterEncoding("UTF-8");
        // 获取URI
        // http://localhost/fruit.do?id=9&fname=apple&price=10
        // uri:/fruit.do 截取字符串得到 fruit.do
        // String uri = req.getRequestURI().substring(7);
        String servletPath = req.getServletPath(); // 返回 "/fruit.do"
        String uri = servletPath.substring(1, servletPath.lastIndexOf(".do"));
        String oper = req.getParameter("oper");
        // 截取字符串 得到fruit
        // uri = uri.substring(0, endIndex);
        System.out.println("uri = " + uri);
        // 根据 得到的 请求 fruit 从 IOC容器中 取出bean实例
        // 需要在bean.xml中配置fruit的id,uri假如是 fruit，对应是 FruitController的实例
        /*
        <bean id="fruit" class="com.fruit.yuluo.controller.FruitController">
            <property name="fruitService" ref="fruitService"></property>
        </bean>
        * */
        Object bean = beanFactory.getBean(uri);
        
        // 这里的bean是一个FruitController对象 @xxzz,且 @xxzz.fruitService = new fruitServiceImpl
        // 默认不传操作是列表功能
        if (StringUtils.isEmpty(oper)){
            oper = "list";
        }
        // 通过反射,获取bean实例 控制器实例 的Class对象
        Class beanClass = bean.getClass();
        // 获取 控制器实例中的方法
        // 由于 方法中参数类型数量不同，这里使用获取方法列表
        Method[] methods = beanClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            // 判断操作名与方法名一致
            if (oper.equals(method.getName())){
                try {
                    // 调用控制器中的方法
                    method.setAccessible(true);
                    // 获取方法列表
                    Parameter[] parameters = method.getParameters();
                    // 创建一个参数结果的列表
                    Object[] parameterValueArr = new Object[parameters.length];
                    // 遍历
                    for (int j = 0;j<parameterValueArr.length;j++){
                        // 获取参数对象
                        Parameter parameter = parameters[j];
                        // 获取参数名字-需要在编辑器中配置 -parameters
                        String parameterName = parameter.getName();
                        // java.lang.Integer;typeName为Integer
                        String typeName = parameter.getType().getName();
                        // 设置参数值
                        Object parameterValue = null;
                        // 分支结构
                        switch (parameterName){
                            case "session":
                                parameterValue = req.getSession(); // 值是一个session对象
                                break;
                            case "req":
                                parameterValue = req;
                                break;
                            case "resp":
                                parameterValue = resp;
                                break;
                            default:
                                // 默认情况 从 请求域中获取到的 基本数据类型
                                String reqParameter = req.getParameter(parameterName);
                                //此处我们不考虑一个名称对应多个值的情况
                                //http://localhost/fruit.do?hobby=football&hobby=basketball&hobby=pingpong
                                //String[] hobbies = request.getParameterValues("hobby");
                                if (StringUtils.isNotEmpty(reqParameter)){
                                    switch (typeName){
                                        case "java.lang.Integer":
                                            parameterValue = Integer.parseInt(reqParameter);
                                            break;
                                        case "java.lang.Double":
                                            parameterValue = Double.parseDouble(reqParameter);
                                            break;
                                        default:
                                            parameterValue = reqParameter;
                                            break;
                                    }
                                }
                                break;

                        }
                        // 存放参数值
                        parameterValueArr[j] = parameterValue;
                    }
                    // 遍历参数值
                    for (Object o : parameterValueArr) {
                        System.out.println("o = " + o);
                    }
                    // 执行方法
                    Object returnObj = method.invoke(bean, parameterValueArr);
                    // 处理视图转发
                    if (returnObj != null){
                        // 强转为String类型
                        String returnStr = (String) returnObj;
                        // 判断
                        if (returnStr.startsWith("redirect:")){
                            // 获取后边的字符串
                            returnStr = returnStr.substring("redirect:".length());
                            // 重定向
                            resp.sendRedirect(returnStr);
                        }else {
                            // 转发页面
                            processTemplate(returnStr,req,resp);
                        }
                    }
                    // 结束循环
                    return ;

                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("未找到"+oper+"方法,或执行方法报错");
                }
            }
        }
    }
}
