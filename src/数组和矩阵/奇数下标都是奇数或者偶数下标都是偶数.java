package 数组和矩阵;
/*    《奇数下标都是奇数或者偶数下标都是偶数》
 * 给定一个长度不小于2的数组arr,实现一个函数调整arr,要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数
 * 要求：时间复杂度O(N),额外空间复杂度O(1)
 */

import java.util.Arrays;

public class 奇数下标都是奇数或者偶数下标都是偶数 {
    /*
     * 定义两个变量even, odd，如果arr的最后一个元素是偶数，和even位置的数交换
     * 如果arr的最后一个数是奇数，和odd位置的数交换
     * 不管和谁交换，even 和 odd 都加2
     */
    public static void modify(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int even = 0;  //even表示arr最左边偶数下标，初始为0
        int odd = 1;   //odd表示arr最左边奇数下标，初始为1
        int end = arr.length - 1;
        while (even <= end && odd <= end) {
            if ((arr[end] & 1) == 0) {   //判断是偶数
                swap(arr, end, even);
                even = even + 2;
            } else {
                swap(arr, end, odd);
                odd = odd + 2;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        modify(a);
        System.out.println(Arrays.toString(a));
    }
}
