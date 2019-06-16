package 校招真题2018;

/*
 * 问题：给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，
 * 要求时间复杂度：O(n)，空间复杂度：O(1)
 * 解法：找到数组中的最大值max1和次大值max2和次次大值max3, 还需要找到最小值min1和次小值min2,(负负得正)
 *      返回max(max1*max2*max3, min1*min2*max1)
 */

import java.util.Scanner;

public class 最大乘积 {

    public static void main(String[] args) {
        //不知道数组长度，接收整型字符串
        /*Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
            System.out.println(arr[i]);
        }
        */
        //知道数组长度，接收整型数组
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long[] arr = new long[len];
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        //找最大值和次大值
        long max1 = 0, max2 = 0, max3 = 0, min1 = 0, min2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (arr[i] > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = arr[i];
                } else if (arr[i] > max2) {
                    max3 = max2;
                    max2 = arr[i];
                } else if (arr[i] > max3) {
                    max3 = arr[i];
                } else if (arr[i] < min1) {
                    min2 = min1;
                    min1 = arr[i];
                } else if (arr[i] < min2) {
                    min2 = arr[i];
                } else {
                    continue;
                }
            }
        }
        long max = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        System.out.println(max);
    }
}
