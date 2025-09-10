package com.newJDK.TestLambda.Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestStream {
    // 创建一个数组集合
    static List<Student> list = new ArrayList<Student>();
    static {
        // 向集合中添加元素
        Student stu1 = new Student("hanser",21,'女');
        Student stu2 = new Student("yousa",19,'女');
        Student stu3 = new Student("cat",20,'女');
        Student stu4 = new Student("Akie",20,'女');
        Student stu5 = new Student("senere",20,'女');
        Student stu6 = new Student("senere",20,'女');
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu5);
        list.add(stu6);
    }
    // filter过滤
    @Test
    public void m1(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        // filter的使用
        stream.filter((stu) -> stu.getName().equals("hanser")).forEach(System.out::println);
    }
    // map的使用:对每个元素进行处理
    @Test
    public void m2(){
        // 创建 流对象
        Stream<String> stream = Stream.of("abc", "edf");
        // filter的使用
        stream.map((str)->str.toUpperCase()).forEach(System.out::println);
    }
    // 去重
    @Test
    public void m3(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        // 需要在 Student类中重写 equals方法和hashCode方法
        stream.distinct().forEach(System.out::println);
    }
    @Test
    // 限制条数
    public void m4(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        stream.limit(3).forEach(System.out::println);
    }
    // 跳过
    @Test
    public void m5(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        stream.skip(1).forEach(System.out::println);
    }
    // 扁平化映射：
    @Test
    public void m6(){
        // 创建 流对象
        Stream<String> stream = Stream.of("Hanser", "is", "MyAngle");
        // 遍历到流对象中的每个元素
        stream.flatMap(TestStream::buildstrToStream).forEach(System.out::println);

    }
    // 定义一个方法处理逻辑:传入一个string字符串，返回一个流对象
    public static Stream<Character> buildstrToStream(String str){
        // 字符串转为字符数组
        char[] chars = str.toCharArray();
        // 新建一个集合
        List<Character> list = new ArrayList<>();
        // 把字符数组的每一个字符添加到集合中
        for (char aChar : chars) {
            list.add(aChar);
        }
        // 返回一个流对象
        return list.stream();
    }

    // 排序
    @Test
    public void m7(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        // Student类中实现了Comparable接口
        stream.sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        }).forEach(System.out::println);
    }
    // 终止操作
    // 判断是否全部匹配条件
    @Test
    public void m8(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        boolean res = stream.filter(stu -> stu.getAge() > 20).allMatch(stu -> stu.getSex() == '女');
        System.out.println("结果为"+res);
    }

    // 判断是否有一个匹配条件
    @Test
    public void m9(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        boolean res = stream.filter(stu -> stu.getAge() > 20).anyMatch(stu -> stu.getSex() == '女');
        System.out.println("结果为"+res);
    }

    // 返回流中元素数量
    @Test
    public void m10(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        long count = stream.count();
        System.out.println("结果为"+count);
    }

    // 返回流中第一个元素
    @Test
    public void m11(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        Optional<Student> first = stream.findFirst();
        System.out.println("结果为"+first);
    }

    // 返回流中最小的元素
    @Test
    public void m12(){
        // 创建 流对象
        Stream<Student> stream = list.stream();
        Optional<Student> maxOne = stream.min(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("结果为"+maxOne);
    }
}
