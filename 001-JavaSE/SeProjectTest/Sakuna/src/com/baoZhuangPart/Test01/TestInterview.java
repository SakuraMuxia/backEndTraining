package com.baoZhuangPart.Test01;

public class TestInterview {
    public static void main(String[] args) {

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true

        Integer c = -129;
        Integer d = -129;

        System.out.println(c == d); // false


        Integer e = new Integer(-128);
        Integer f = new Integer(-128);
        System.out.println(e == f); // false 只要是new的  地址永远都不相同

        Short s1 = 200;
        Short s2 = 200;
        System.out.println(s1 == s2); // false


        Short s3 = 100;
        Short s4 = 100;
        System.out.println(s3 == s4); // true

        Long l1 = 100L;
        Long l2 = 100L;
        System.out.println(l1 == l2); // true

        Long l3 = 128L;
        Long l4 = 128L;
        System.out.println(l3 == l4); // false

        Character ch1 = 28;
        Character ch2 = 28;
        System.out.println(ch1 == ch2); // true
    }
    }
