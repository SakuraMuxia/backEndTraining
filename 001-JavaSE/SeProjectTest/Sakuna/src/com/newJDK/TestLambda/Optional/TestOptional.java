package com.newJDK.TestLambda.Optional;

import org.junit.Test;

import java.util.Optional;

public class TestOptional {

    // Optional类中的of方法
    @Test
    public void m1(){
        Optional<String> op1 = Optional.of("Hanser");
        System.out.println("Optional对象：" + op1); // Optional[Hanser]
    }

    // Optional类中的empty方法
    @Test
    public void m2(){
        Optional<String> op1 = Optional.empty();
        System.out.println("Optional对象：" + op1); // Optional.empty
    }

    // Optional类中的ofNullable(Object obj)
    @Test
    public void m3(){
        Optional<String> op1 = Optional.ofNullable("123");
        Optional<String> op2 = Optional.ofNullable(null);
        System.out.println("Optional对象：" + op1);
        System.out.println("Optional对象：" + op2);
    }

    // Optional类中的ofNullable(Object obj)
    @Test
    public void m4(){
        Optional<String> op1 = Optional.ofNullable("123");
        String value = op1.get();
        System.out.println("value = " + value);
    }

    // isPresent
    @Test
    public void m5(){
        Optional<String> op1 = Optional.ofNullable(null);
        // 消费型接口，有参，返回值无
        op1.ifPresent(System.out::println);
    }

    // isPresent
    @Test
    public void m6(){
        Optional<String> op1 = Optional.ofNullable(null);
        String value = op1.orElse("Akie");
        System.out.println("value = " + value);
    }

    // isPresent
    @Test
    public void m7(){
        Optional<String> op1 = Optional.ofNullable(null);
        String str = "Warma Kawaii";
        String value = op1.orElseGet(str :: toString);
        // String value1 = op1.orElseGet(str -> str.toString()); // 错误的
        String value1 = op1.orElseGet(() -> str.toString()); // 正确的
        System.out.println("value = " + value);
        System.out.println("value = " + value1);
    }

    // isPresent
    @Test
    public void m8(){
        Optional<String> op1 = Optional.ofNullable(null);
        String res = op1.orElseThrow(() -> new RuntimeException("运行时异常"));
        System.out.println("res = " + res);
    }
}
