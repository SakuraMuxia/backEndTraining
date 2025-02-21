package com.yuluo;

public class ShortArray {
    public static void main(String[] args) {
        int [] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前的数组:");
        printArray(arr);
        // 排序
        Bubble(arr);
        // 打印排序后的数组
        System.out.println("排序后的数组:");
        printArray(arr);
    }
    // 冒泡排序
    public static void Bubble(int [] arr){
        int length = arr.length;
        boolean swapped;
        for(int i = 0;i < length -1;i++){
            swapped = false;
            for(int j = 0; j< length -1 -i;j++){
                if(arr[j]>arr[j+1]){
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // 如果没有发生交换
            if(!swapped){
                break;
            }
        }
    }
    // 打印数组
    public static void printArray(int[] arr) {
        for (int i :arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    // 打印数组
    public static void printArray2(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
