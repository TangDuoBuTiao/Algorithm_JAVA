package 排序;

import java.util.Arrays;

public class 冒泡排序 {

    /* 把最大的数放在最后面
     * param: arr  待排序数组
     * param: n   在数组中的[0,n]区间找到最大的数
     */
    public static void bubble(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
    }
    //循环调用bubble函数
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n; i >= 1; i--) {
            bubble(arr, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 6, 8, 2, 1, 4, 7};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
}
