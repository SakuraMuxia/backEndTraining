package com.fruit.yuluo.service;

import com.fruit.yuluo.pojo.Fruit;

import java.util.List;

public interface FruitService {

    // 根据查询关键字检索指定页的数据
    List<Fruit> getFruitList(String keyword,Integer pageNo,Integer pageSize);

    // 查询总数
    Integer getTotalNum(String keyword);

    // 查询总页数
    Integer getTotalPageNum(String keyword,Integer pageSize);

    // 添加新库存
    void addFruit(Fruit fruit);

    // 修改库存
    void updateFruit(Fruit fruit);

    // 删除指定库存
    void delFruit(Integer id);

    // 查询指定库存
    Fruit getFruitById(Integer id);
}
