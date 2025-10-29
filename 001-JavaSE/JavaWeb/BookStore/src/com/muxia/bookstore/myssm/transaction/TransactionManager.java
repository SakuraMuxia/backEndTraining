package com.muxia.bookstore.myssm.transaction;

import com.muxia.bookstore.myssm.utils.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;

/*
* 这个类的作用是为了 事务管理
* 定义成抽象，是为了避免被new对象
* */
public abstract class TransactionManager {
    // 开启事务
    public static void begin(){
        // 关闭自动提交
        try {
            System.out.println("开启事务...");
            Connection connection = ConnUtil.getConnection();
            connection.setAutoCommit(false);
            System.out.println("connect对象的 hashCode："+ connection.hashCode());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    };
    // 提交事务
    public static void submit(){
        try {
            System.out.println("提交事务...");
            Connection connection = ConnUtil.getConnection();
            connection.commit();
            System.out.println("connect对象的 hashCode："+ connection.hashCode());
            // 在一次事务中，同一个 Connection 需要贯穿整个操作（多次 SQL 执行）
            // 如果在 submit() 或 rollback() 里就 close()，那事务中的后续操作就会失效（连接被提前释放了
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    };
    // 回滚事务
    public static void rollback(){
        try {
            System.out.println("回滚事务...");
            Connection connection = ConnUtil.getConnection();
            connection.rollback();
            System.out.println("connect对象的 hashCode："+ connection.hashCode());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    };
}
