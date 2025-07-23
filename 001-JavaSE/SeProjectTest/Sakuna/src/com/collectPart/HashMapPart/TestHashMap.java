package com.collectPart.HashMapPart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {
        // 创建HashMap对象
        HashMap<String,String> hashMap = new HashMap<String,String>();
        // 添加元素
        hashMap.put("aqua", "44.5");
        hashMap.put("yousa", "当春乃发生");
        hashMap.put("Reine", "兔次元");



        // size方法
        int size = hashMap.size();
        System.out.println("size = " + size); // size = 3

        // replact替换
        String replaceItem = hashMap.replace("Reine", "油菜花");
        System.out.println("replaceItem = " + replaceItem); // 之前的 值的内容

        // remove 删除
        String rmItem = hashMap.remove("Reine");
        System.out.println("rmItem = " + rmItem); // 键不存在时 返回 null,健存在时返回 键的值

        // 获取键的值
        Set<String> keysSet = hashMap.keySet();
        System.out.println("keysSet = " + keysSet);

        // 获取所有值
        Collection<String> values = hashMap.values();
        System.out.println("values = " + values); // values = [当春乃发生, 44.5, 北京站]

        // 判断hashMap是否为空
        boolean isempty = hashMap.isEmpty();
        System.out.println("isempty = " + isempty);

        // 获取元素的值
        String aqua = hashMap.get("aqua");
        System.out.println("aqua = " + aqua); // aqua = 44.5



        // 是否包含某个值
        boolean res = hashMap.containsValue("44.5");
        System.out.println("res = " + res); // res = true

        // 是否包含某个键
        boolean res2 = hashMap.containsKey("aqua");
        System.out.println("res2 = " + res2); // res2 = true

        // 清空集合
        hashMap.clear();

        // 获取所有键值对的组合
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        System.out.println("entries = " + entries); // entries = []

        // 遍历
        // 方式1

    }
}
