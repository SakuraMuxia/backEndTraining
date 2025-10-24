package com.muxia.qqzone.myssm.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnUtil {
    // 定义静态数据
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PWD;
    // 定义静态的 数据库连接池对象
    private static DruidDataSource dataSource;
    // 定义一个线程传送带对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    // 设置数据库连接池信息
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
            throw new RuntimeException(e.getMessage());
        }
    }

    // 创建连接对象
    public static Connection createConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    // 从线程传送带上获取连接对象
    public static Connection getConnection(){
        // 从线程传送带上获取工具
        Connection connection = threadLocal.get();
        // 如果不存在
        if (connection == null){
            // 创建一个connection对象
            connection = createConnection();
            // 放置在传送带上
            threadLocal.set(connection);
        }
        return connection;
    }

    // 关闭连接对象
    public static void closeConn(){
        // 从传送带上取出
        Connection connection = threadLocal.get();
        if (connection != null){
            // 关闭连接
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
            threadLocal.remove(); // ✅ 非常重要
            // threadLocal.set(null);
        }
    }

    // 关闭流对象
    public static void closeStream(Statement stmt,ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
