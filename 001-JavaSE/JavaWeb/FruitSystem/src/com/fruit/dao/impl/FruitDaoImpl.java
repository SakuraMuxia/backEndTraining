package com.fruit.dao.impl;

import com.fruit.dao.BaseDao;
import com.fruit.dao.FruitDao;
import com.fruit.pojo.Fruit;

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
        int resRow = this.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
        // 打印受影响行数
        System.out.println("resRow = " + resRow);
    }

    @Override
    public void delFruit(Integer id) {
        String sql = "delete from goods where id = ?";
        int resRow = this.executeUpdate(sql, id);
        System.out.println("resRow = " + resRow);
    }

    @Override
    public Fruit getFruit(Integer id) {
        return null;
    }

    @Override
    public Fruit getFruit(String name) {
        return null;
    }

    @Override
    public void updateFruit(Fruit fruit) {

    }
}
