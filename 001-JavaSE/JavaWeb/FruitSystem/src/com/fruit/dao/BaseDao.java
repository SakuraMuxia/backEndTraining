package com.fruit.dao;

import com.fruit.utils.ClassUtil;
import com.fruit.utils.DButil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 定义BaseDao为一个抽象类
public abstract class BaseDao<T> {
    // 定义泛型的名称
    private String entityClassName;
    // 定义ResultSet结果集
    private ResultSet rs;
    // 连接池对象
    Connection connection = null;
    // sql语句对象
    PreparedStatement pstm = null;

    // 在无参构造中，获取泛型类型，子类调用构造，默认调用父类的无参构造
    public BaseDao(){
        // 调用
        getEntityClassName();

    }
    // 获取子类实例给父类泛型T传入的名称
    private void getEntityClassName(){
        // 通过子类实例对象，获取父类（自己）的泛型T的实际名称
        // 此处的this代表的是FruitDaoImpl实例，而不是BaseDao
        // this.getClass()得到的就是FruitDaoImpl的Class对象
        // getGenericSuperclass() 获取带有泛型的父类,因此可以获取到 BaseDao<Fruit>
        // 因为我们是这样定义的：class FruitDaoImpl extends BaseDao<Fruit>，所以泛型父类是： BaseDao<Fruit>
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        // 把父类的泛型信息，从通用的 Type 强转为 ParameterizedType，以便后续获取实际的泛型参数。
        // 强转为ParameterizedType类型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        // getActualTypeArguments 获取实际的类型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        // 因为当前BaseDao<T>后面只有一个泛型位置，所以此处我们使用的是[0]
        // getTypeName() 获取类型名称
        // getTypeName() 返回完整类名，例如 "com.xxx.pojo.Fruit"
        String typeName = actualTypeArguments[0].getTypeName();
        entityClassName = typeName;
    }

    // 定义设置参数的方法
    private void setParams(PreparedStatement psmt , Object... params) throws SQLException {
        if(params!=null && params.length>0){
            for (int i = 0; i < params.length; i++) {
                psmt.setObject(i+1,params[i]);
            }
        }
    }

    // 执行增删改的操作
    protected int executeUpdate(String sql,Object ...params){
        // 去除空格，并转为小写
        sql = sql.trim().toUpperCase();
        // 设置标记是否是插入语句
        boolean insertFlag = sql.startsWith("INSERT INTO");
        // 获取连接对象
        connection = DButil.getConnection();

        try {
            // 判断是否是插入语句
            if (insertFlag){
                // 获取sql执行语句对象,插入语句
                pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            }else{ // 非插入语句
                pstm = connection.prepareStatement(sql);
            }
            // 给sql语句传入参数
            setParams(pstm,params);
            // 执行sql
            int resRow = pstm.executeUpdate();
            // 返回
            if(insertFlag) { // 如果是插入语句
                // 获取自增id
                rs = pstm.getGeneratedKeys();
                // 如果返回有值
                if(rs.next()){
                    // 获取第一列数据
                    return (rs.getInt(1));
                }
            }else{
                return resRow; // 返回默认受影响行数
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            DButil.close(connection,pstm,rs);
        }
        return 0;
    }

    // 查询的方法
    protected List<T> executeQuery(String sql,Object ...params){
        List<T> list = new ArrayList<>();
        connection = DButil.getConnection();
        try {
            // 获取statement对象
             pstm = connection.prepareStatement(sql);
             // 设置SQL参数
            setParams(pstm,params);
            // 执行SQL
            rs = pstm.executeQuery();
            // 方式1：通过反射来处理
            // 方式2：通过数据解析器来处理（见JDBC章节）
            // 获取结果集的元数据，也就是每一行的数据
            ResultSetMetaData metaData = rs.getMetaData();
            // 获取元数据的列数
            int columnCount = metaData.getColumnCount();
            // 遍历结果集
            while(rs.next()){
                // 通过反射获取实体类的Class对象
                Class entityClass = ClassUtil.getEntityClass(entityClassName);
                // 通过反射创建实例,强转为T类型
                T instance = (T)ClassUtil.createInstance(entityClassName);
                // 遍历
                for (int i = 0; i < columnCount; i++) {
                    // 读取列名
                    String columnName = metaData.getColumnName(i + 1);
                    // 获取当前行指定列的值
                    Object columnValue = rs.getObject(i + 1);
                    // 给实例赋值
                    ClassUtil.setProperty(instance,columnName,columnValue);
                }
                // 集合中添加元素
                list.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,pstm,rs);
        }
        return list;
    }
}
