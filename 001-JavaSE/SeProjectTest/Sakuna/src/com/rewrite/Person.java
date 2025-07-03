package com.rewrite;

public class Person {
    private String name;
    private String idCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Person(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
    }

    public Person() {
    }

    public void printInfo(){
        System.out.println("我的名字是" + name);
        System.out.println("我的id是" + idCard);
    }

    @Override
    // 自定义类的equals方法重写
    public boolean equals(Object obj){ // 调用的过程 符合向上转型
        // 首先判断地址
        if(this == obj){
            return true;
        }
        // 加一层判断，如果类型不相同直接返回false
        if (obj instanceof  Person){
            // 向下转型(强制类型转换)
            Person p1 = (Person) obj;
            if (this.name.equals(p1.name) && this.idCard.equals(p1.idCard)){
                return true;
            }
        }
        return false;
    }

    // 自定义类重写哈希值计算
    // 要保证在equals比较为true的情况下 两个对象hashCode相同
    // 上边重写的 equals 方法是根据人的名字和身份证号比较的
    // 所以我们也要根据人的名字和身份证号来计算hash值
    @Override
    public int hashCode() {
        int result = 1; // 哈希值结果
        int prime = 31; // 权重
        result = result * prime + (this.name == null ? 0 : this.name.hashCode()); // 这里使用了 String类重写的hashCode方法
        result = result * prime + (this.idCard == null ? 0 : this.idCard.hashCode()); // 这里使用了 String类重写的hashCode方法
        return result;
    }
}
