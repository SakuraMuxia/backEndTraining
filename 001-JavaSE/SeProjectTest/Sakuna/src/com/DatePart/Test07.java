package com.DatePart;

import java.math.BigInteger;

public class Test07 {
    public static void main(String[] args) {
        BigInteger bigInteger1 = new BigInteger("3141592653");
        BigInteger bigInteger2 = new BigInteger("3141592654");

        BigInteger res = bigInteger1.divide(bigInteger2);
        System.out.println("res = " + res); // res = 0
    }
}
