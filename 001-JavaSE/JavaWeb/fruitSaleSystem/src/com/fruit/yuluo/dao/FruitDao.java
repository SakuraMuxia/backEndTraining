package com.fruit.yuluo.dao;
import com.fruit.yuluo.pojo.Fruit;

import java.util.List;

public interface FruitDao {

    // 获取所有的库存记录
    @Deprecated
    List<Fruit> getFruitList();
    // 分页，检索，每页大小
    List<Fruit> getFruitList(String keyword,Integer pageNo,Integer pageSize);

    // 获取库存中的数量
    Integer getTotalNum(String keyword);

    // 添加新库存
    void addFruit(Fruit fruit);

    // 删除指定的库存记录
    void delFruit(Integer id);

    // 获取指定的库存记录
    Fruit getFruitById(Integer id);

    // 修改库存记录
    void updateFruit(Fruit fruit);
}
