package com.throwsPart.Test02;

public class TestVtuber {
    public static void main(String[] args) {
        Vtuber yousa = new Vtuber("sakuna",26,'女');
        yousa.setAge(129);
        try{
            // 对 检查型异常做 catch捕获
            yousa.setSex('女');
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(yousa.toString());
        System.out.println("程序结束");
    }
}
