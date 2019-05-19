package 数组和矩阵;
/*     《不包含本位置值的累乘数组》
 * 问题：给定一个整型数组arr, 返回不包含本位置的累乘数组
 * Eg: arr=[2,3,1,4], 返回[12,8,24,6],除自己之外，其他位置上的累乘
 */

import java.util.Arrays;

public class ProductArr {
    //要求：时间复杂度O(N),除需要返回的结果数组外，额外空间复杂度为O(1)
    //解法：使用除法
    public static int[] product1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int[] res = new int[arr.length];
        int all = 1;
        int numZero = 0;
        int indexZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                numZero++;
                indexZero = i;
            }
            all = all * arr[i];
        }
        if (numZero > 1) {
            return res;
        } else if (numZero == 1) {
            res[indexZero] = all;
            return res;
        } else {
            for (int j = 0; j < res.length; j++) {
                res[j] = all / arr[j];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 4};
        System.out.println(Arrays.toString(product1(a)));
    }
}
