package com.Mostclass.StringPart;

public class TestString01 {
    public static void main(String[] args) {
        String str1 = "abc hello world";
        String str2 = "abc hello World";

        int length = str1.length();
        System.out.println("length = " + length);
        System.out.println("---------------------------");
        boolean result = str1.equals(str2);
        System.out.println("result = " + result);
        System.out.println("---------------------------");
        boolean result02 = str1.equalsIgnoreCase(str2);
        System.out.println("result02 = " + result02);
        System.out.println("---------------------------");
        String lowerCase01 = str2.toLowerCase();
        System.out.println("lowerCase01 = " + lowerCase01);
        System.out.println("---------------------------");
        String UpperCase02 = str2.toUpperCase();
        System.out.println("UpperCase02 = " + UpperCase02);
        System.out.println("---------------------------");
        String concatString = str1.concat(str2);
        System.out.println("concatString = " + concatString);
        int index = str1.indexOf("abc");
        System.out.println("index = " + index);
        System.out.println("---------------------------");
        int index2 = str1.lastIndexOf("o");

        System.out.println("index2 = " + index2);
        int index3 = str1.lastIndexOf(99);
        System.out.println("index3 = " + index3);
        System.out.println("---------------------------");
        String substring01 = str1.substring(2);
        String substring02 = str1.substring(2,5);
        System.out.println("substring01 = " + substring01);
        System.out.println("substring02 = " + substring02);

        String[] splitRes = str1.split(" ");
        for (int i = 0; i < splitRes.length; i++) {
            System.out.println(splitRes[i]);
        }

        char c = str1.charAt(1);
        System.out.println("c = " + c);

        boolean ac = str1.contains("ac");
        System.out.println("ac = " + ac);

        boolean res = str1.isEmpty();
        System.out.println("res = " + res);

        String replace = str2.replace('a', 'A');
        String replace02 = str1.replace("abc", "AEC");
        System.out.println("replace = " + replace);
        System.out.println("replace02 = " + replace02);

        String res1 = String.valueOf(5612);
        System.out.println("res1 = " + res1); // 5612
        // 效果如同
        int a = 5612;
        String s1 = a + "";
        System.out.println("s1 = " + s1); // 5612



    }
}
