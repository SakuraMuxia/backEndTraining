package com.collectPart.SetPart;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    /**
     *  重写 compare方法  自定义比较规则  最终返回值为int类型
     * @param p1 the first object to be compared.
     * @param p2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Person p1, Person p2) {
        // p1大于p2 返回正数  p1小于p2 返回负数  p1==p2 返回0
        return  p1.getHeight() > p2.getHeight() ? 1 :  (p1.getHeight() < p2.getHeight() ? -1  : 0) ;
    }
}
