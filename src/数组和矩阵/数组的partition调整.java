package 数组和矩阵;
/*           《数组的partition调整》
 * 问题： 给定一个有序数组arr,调整arr使得这个数组的左半部分没有重复元素且升序，而不用保证右部分是否有序
 * Eg: arr=[1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9], 调整之后arr=[1,2,3,4,5,6,7,8,9,...]
 *
 * 要求：原问题和补充问题：时间O(N),   空间O(1)
 */

import java.util.Arrays;

public class 数组的partition调整 {
    public static void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int u = 0;
        int i = 1;
        while (i != arr.length) {
            if (arr[i++] != arr[u]) {
                swap(arr, ++u, i - 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
     * 补充问题：给定一个数组arr,其中只可能含有0，1，2三个值，请实现arr的排序
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = -1;   //左区最右的位置，保证left左边全是0
        int index = 0;   //中间区最右的位置，保证[left+1,.,index]里面全是1
        int right = arr.length;   //[]right,.,N-1]里全是2
        //每次循环，不是index++, 就是right--
        while (index < right) {
            if (arr[index] == 0) {
                swap(arr, ++left, index++);   // ++left是执行这条语句时就+1了，index++是执行这条语句时是index,下次+1
            } else if (arr[index] == 2) {
                swap(arr, index, --right);
            } else {
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        int[] b = {0, 0, 1, 2, 2, 1, 2, 2, 0, 0};
        // leftUnique(a);
        sort(b);
    }
}
