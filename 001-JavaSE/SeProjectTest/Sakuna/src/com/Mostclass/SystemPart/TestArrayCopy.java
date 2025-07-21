package com.Mostclass.SystemPart;

public class TestArrayCopy {
    public static void main(String[] args) {
        int[] src = {1,2,3,4,5};
        int[] dest = new int[5];

        System.arraycopy(src, 0, dest, 0, 5);

        // 打印结果
        for (int i : dest) {
            System.out.print(i + " ");
        }
    }
}
