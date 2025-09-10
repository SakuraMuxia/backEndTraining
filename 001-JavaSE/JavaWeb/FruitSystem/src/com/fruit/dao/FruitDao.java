package com.fruit.dao;

import com.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDao {
    // 获取所有的库存记录
    List<Fruit> getFruitList();

    // 添加新库存
    void addFruit(Fruit fruit);

    // 删除指定的库存记录
    void delFruit(Integer id);

    // 获取指定的库存记录
    Fruit getFruit(Integer id);
    Fruit getFruit(String name);

    // 修改库存记录
    void updateFruit(Fruit fruit);
}
