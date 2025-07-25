package com.collectPart.TreeMapPart;

public class VUP implements Comparable<VUP> {
    private String name;
    private int age;
    // 封装
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public VUP() {
    }

    public VUP(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 重写方法

    @Override
    public String toString() {
        return "VUP{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(VUP vup) {
        // 比较规则：
        // x 当前对象，y传入的对象；
        // x=y 则 返回 0；
        // x>y 则返回 1；返回正数即可
        // x<y 则返回 -1;返回负数即可

        // 方式1：
        return vup.getAge() - this.getAge();

        // 方式2：
        // return  this.getAge() > vup.getAge() ? 1 :  (this.getAge() < vup.getAge() ? -1  : 0) ;

        // 方式3：
        // if(this.getAge() > vup.getAge()){ // 当前对象的年龄大于传入对象的年龄
            //            return 1; // 返回正数
            //        }else if(this.getAge() < vup.getAge()){ // 当前对象的年龄小于传入对象的年龄
            //            return -1; // 返回负数
            //        }
            //        return 0; // 以上条件都不成立 表示两个对象的年龄相等 则 返回0
    }
}
