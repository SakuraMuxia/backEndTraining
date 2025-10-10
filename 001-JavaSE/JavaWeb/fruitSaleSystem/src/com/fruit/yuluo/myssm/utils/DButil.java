package com.fruit.yuluo.myssm.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DButil {
    // 定义静态数据
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PWD;
    // 定义静态的 数据库连接池对象
    private static DruidDataSource dataSource;

    // 静态代码块，在类加载时读取配置
    static {
        try {
            // 创建Properties Map集合类
            Properties prop = new Properties();
            // 获取当前类加载器，获取 jdbc的读取流
            InputStream in = DButil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 加载配置文件
            prop.load(in);

            // 获取数据库连接池对象(方式1)
            // 方式 1：DruidDataSourceFactory.createDataSource(prop)
            // 直接用 工厂方法 根据 Properties 配置生成一个 DruidDataSource 对象
            // 配置集中在 jdbc.properties 文件里，支持 Druid 的各种高级配置
            // dataSource = DruidDataSourceFactory.createDataSource(prop);

            // 创建数据库连接池对象(方式2)
            // 手动创建 Druid 连接池对象，然后逐个设置属性
            dataSource = new DruidDataSource();

            // 获取properties文件中的值
            DRIVER = prop.getProperty("DRIVER");
            URL = prop.getProperty("URL");
            USER = prop.getProperty("USER");
            PWD = prop.getProperty("PWD");

            // 加载mysql驱动(数据库连接池 Druid会自动加载mysql驱动)
            // Class.forName(DRIVER);

            // 设置用户名，密码
            dataSource.setDriverClassName(DRIVER);
            dataSource.setUrl(URL);
            dataSource.setUsername(USER);
            dataSource.setPassword(PWD);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接,返回一个连接对象
    public static Connection getConnection() {
        try {
           return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭连接
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
