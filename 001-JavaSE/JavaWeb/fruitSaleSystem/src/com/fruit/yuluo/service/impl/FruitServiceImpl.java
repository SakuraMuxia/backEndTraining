package com.fruit.yuluo.service.impl;

import com.fruit.yuluo.dao.FruitDao;
import com.fruit.yuluo.dao.impl.FruitDaoImpl;
import com.fruit.yuluo.ioc.BeanFactory;
import com.fruit.yuluo.ioc.impl.ClassPathXmlApplicationContext;
import com.fruit.yuluo.pojo.Fruit;
import com.fruit.yuluo.service.FruitService;

import java.util.List;

public class FruitServiceImpl implements FruitService {
    // 创建FruitDao对象
    private FruitDao fruitDao;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo, Integer pageSize) {
        return fruitDao.getFruitList(keyword,pageNo,pageSize);
    }

    @Override
    public Integer getTotalNum(String keyword) {
        return fruitDao.getTotalNum(keyword);
    }

    @Override
    public Integer getTotalPageNum(String keyword, Integer pageSize) {
        int totalNum = fruitDao.getTotalNum(keyword).intValue();
        int totalPageNum = (totalNum + pageSize - 1) / pageSize;
        return totalPageNum;
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDao.addFruit(fruit);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDao.updateFruit(fruit);
    }

    @Override
    public void delFruit(Integer id) {
        fruitDao.delFruit(id);
    }

    @Override
    public Fruit getFruitById(Integer id) {
        return fruitDao.getFruitById(id);
    }
}
