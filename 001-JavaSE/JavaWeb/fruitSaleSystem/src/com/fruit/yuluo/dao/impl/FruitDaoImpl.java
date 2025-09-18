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
