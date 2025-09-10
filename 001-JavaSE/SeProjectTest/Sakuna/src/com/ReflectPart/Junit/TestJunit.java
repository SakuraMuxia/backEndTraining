package com.ReflectPart.Junit;

import org.junit.*;

public class TestJunit {
    @Before
    public void before(){
        System.out.println("当前类中的每个实例方法执行之前 此方法会自动执行一次 ");
    }
    @After
    public void after(){
        System.out.println("当前类中的每个实例方法执行之后 此方法会自动执行一次 ");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("*******当前类中的方法 执行之前 只执行一次*******");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("*******当前类中的方法 执行之后 只执行一次*******");
    }

    @Test
    public void m1(){
        System.out.println("hello world m1");
    }

    @Test
    public void m2(){
        System.out.println("hello world m2");
    }
}
