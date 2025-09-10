package com.newJDK.TestLambda;

public class Test2 {
    public static void main(String[] args) {
        // lambda表达式 通过接口匹配方法体，直接写方法体
        A a1 = () -> System.out.println("你好");
        // 调用
        a1.m1();

        // 接口匹配构造方法的无参构造方法体
        A a2 = Student :: new;
        a2.m1();

        // 接口匹配构造方法的有参构造方法体
        B b1 = Student :: new;
        b1.m1("赵四");

        // 接口匹配构造方法的有参构造方法体
        C c1 = Student :: new;
        c1.m1("a", 20);

        // 思考：哪个方法首先为静态方法
        // 并且参数为布尔类型 返回值为String类型的,这样的方法体，在String类中存在
        // 例如使用String类中的 valueOf方法
        D<String,Boolean> d1 = String :: valueOf;
        // 调用接口中的方法执行 valueOf方法体代码
        int length = d1.m1(true).length();
        System.out.println("length = " + length);
        // 使用 Math类中 的 abs  静态方法，作为方法体，匹配D接口
        D<Double,Double> d2 = Math :: abs;
        System.out.println(d2.m1(20.0));
        // 使用 Math类中 的 abs  静态方法，作为方法体，匹配D接口
        D<Integer,Float> d3 = Math :: round;
        System.out.println(d3.m1(3.5F));
        // 定义一个 String 类型对象
        String str = "abc";
        // 使用 String类型对象的startsWith方法的方法体，匹配D接口
        D<Boolean,String> d4 = str :: startsWith;
        // 调用方法
        System.out.println(d4.m1("def"));

        D<Boolean,String> d5 = str :: endsWith;
        System.out.println(d5.m1("c"));
        // 使用System工具类中的方法
        E<String> e1 = System.out :: println;
        e1.m1("hello world");
    }
}

class Student{
    private String name;
    private int age;

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

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("两个参数 name age属性的构造方法");
    }

    public Student(String name) {
        this.name = name;
        System.out.println("单个参数name属性的构造方法");
    }

    public Student() {
        System.out.println("无参构造方法");
    }
}

interface A{
    void m1();
}

interface B{
    void m1(String str);
}

interface C{
    void m1(String str,int num);
}

interface E<P>{
    void m1(P p);
}
interface D<R,P>{
    R m1(P p);
}