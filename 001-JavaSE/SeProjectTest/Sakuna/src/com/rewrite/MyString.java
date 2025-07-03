package com.rewrite;

public class MyString {
    // 定义一个静态方法
    public static boolean myEquals(String str1,String str2){
        // 首先判断两个对象地址是否相同
        if(str1 == str2){
            return true;
        }
        // 使用遍历比较内容是否相同
        if (str1.length() != str2.length()){
            return false;
        }
        // 将两个字符串转为char数组
        char [] charArray1 = str1.toCharArray();
        char [] charArray2 = str2.toCharArray();
        // 比较两个char数组内容是否相同
        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] != charArray2[i]){
                return false;
            }
        }
        return true;
    }
    // 测试类
}
