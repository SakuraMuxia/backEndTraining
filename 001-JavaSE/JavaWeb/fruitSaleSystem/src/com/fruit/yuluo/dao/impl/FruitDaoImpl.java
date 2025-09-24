package com.fruit.yuluo.dao.impl;

import com.fruit.yuluo.dao.BaseDao;
import com.fruit.yuluo.dao.FruitDao;
import com.fruit.yuluo.pojo.Fruit;

import java.util.List;

public class FruitDaoImpl extends BaseDao<Fruit> implements FruitDao {
    @Override
    public List<Fruit> getFruitList() {
        String sql = "select * from goods";
        List<Fruit> fruits = this.executeQuery(sql, null);
        return fruits;
    }

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo, Integer pageSize) {
        String sql = "select * from goods where fname like ? or remark like ? limit ? ,?";
        System.out.println("keyword  = " + keyword );
        System.out.println("pageNo = " + pageNo);
        System.out.println("pageSize = " + pageSize);
        List<Fruit> fruits = this.executeQuery(sql,"%"+keyword+"%","%"+keyword+"%",(pageNo-1)*5,pageSize);
        return fruits;
    }

    @Override
    public Integer getTotalCount(String keyword) {
        String sql = "select count(*) from goods where fname like ? or remark like ?";
        List<Object[]> list = this.executeMathQuery(sql,"%"+keyword+"%","%"+keyword+"%");
        // 获取第一列的数值，强转为Long类型，再转为Int类型
        // 涉及到 涉及到 JDBC 的返回值类型。
        // 如果数据库驱动认为该列可能会超出 int 范围（比如 COUNT(*)），也会返回 Long
        // 如果数据库字段类型是 BIGINT（MySQL 的大整数类型），ResultSet.getObject() 会返回 Long 对象。
        // 如果数据库字段类型是 INT，一般返回 Integer
        Long count = (Long) list.get(0)[0];
        int countInt = count.intValue();
        return countInt;
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql = "insert into goods values(0,?,?,?,?)";
        int resRow = this.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getCount(), fruit.getRemark());
    }

    @Override
    public void delFruit(Integer id) {
        String sql = "delete from goods where id = ?";
        int resRow = this.executeUpdate(sql, id);
    }

    @Override
    public Fruit getFruitById(Integer id) {
        String sql = "select * from goods where id = ?";
        Fruit fruit = load(sql, id);
        return fruit;
    }

    @Override
    public Fruit getFruit(String name) {
        return null;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        String sql = "update goods set fname=?,price=?,count=?,remark=? where id=?";
        executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getCount(),fruit.getRemark(),fruit.getId());
    }
}
