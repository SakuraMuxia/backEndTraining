package com.iot.yl.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DButil {
    // 两个数据库连接池
    private static DruidDataSource dataSource1;
    private static DruidDataSource dataSource2;

    // 静态代码块，在类加载时读取配置
    static {
        try {
            // 创建Properties Map集合类
            Properties prop = new Properties();
            // 获取当前类加载器，获取 jdbc的读取流
            InputStream in = DButil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 加载配置文件
            prop.load(in);

            // db1 配置
            dataSource1 = new DruidDataSource();
            dataSource1.setDriverClassName(prop.getProperty("db1.DRIVER"));
            dataSource1.setUrl(prop.getProperty("db1.URL"));
            dataSource1.setUsername(prop.getProperty("db1.USER"));
            dataSource1.setPassword(prop.getProperty("db1.PWD"));
            configDataSource(dataSource1, prop);
            // db2 配置
            dataSource2 = new DruidDataSource();
            dataSource2.setDriverClassName(prop.getProperty("db2.DRIVER"));
            dataSource2.setUrl(prop.getProperty("db2.URL"));
            dataSource2.setUsername(prop.getProperty("db2.USER"));
            dataSource2.setPassword(prop.getProperty("db2.PWD"));
            configDataSource(dataSource2, prop);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 通用获取连接
    public static Connection getConnection(DBType type) throws SQLException {
        switch (type) {
            case DB1: return dataSource1.getConnection();
            case DB2: return dataSource2.getConnection();
            default: throw new IllegalArgumentException("Unknown DBType");
        }
    }

    // 关闭连接
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close(); // Druid 会自动把连接放回连接池
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 配置数据库连接池
    private static void configDataSource(DruidDataSource ds, Properties prop) {
        ds.setInitialSize(Integer.parseInt(prop.getProperty("db.POOL.INITIAL_SIZE")));
        ds.setMinIdle(Integer.parseInt(prop.getProperty("db.POOL.MIN_IDLE")));
        ds.setMaxActive(Integer.parseInt(prop.getProperty("db.POOL.MAX_ACTIVE")));
        ds.setMaxWait(Long.parseLong(prop.getProperty("db.POOL.MAX_WAIT")));
        ds.setValidationQuery(prop.getProperty("db.POOL.VALIDATION_QUERY"));
        ds.setTestOnBorrow(Boolean.parseBoolean(prop.getProperty("db.POOL.TEST_ON_BORROW")));
        ds.setTestWhileIdle(Boolean.parseBoolean(prop.getProperty("db.POOL.TEST_WHILE_IDLE")));
        ds.setTimeBetweenEvictionRunsMillis(
                Long.parseLong(prop.getProperty("db.POOL.TIME_BETWEEN_EVICTION_RUNS_MILLIS")));
        ds.setRemoveAbandoned(Boolean.parseBoolean(prop.getProperty("db.POOL.REMOVE_ABANDONED")));
        ds.setRemoveAbandonedTimeout(
                Integer.parseInt(prop.getProperty("db.POOL.REMOVE_ABANDONED_TIMEOUT")));
        ds.setLogAbandoned(Boolean.parseBoolean(prop.getProperty("db.POOL.LOG_ABANDONED")));
    }
}
