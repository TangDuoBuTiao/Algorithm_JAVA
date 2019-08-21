package 数组和矩阵;
/*           《自然数数组的排序》
 * 给定一个程度为N的整型数组arr, 其中有N个互不相等的自然数1~N,请实现arr的排序，
 * 但是不要把下标0~N-1位置上的数通过直接赋值的方式替换成1~N
 * 要求：时间复杂度O(N),额外空间复杂度O(1)
 */

import java.util.Arrays;

public class 自然数数组的排序 {
    //方法1：从左到右遍历arr,如果arr[i] = i+1, 说明当前位置不需要调整
    //      如果arr[i] != i+1, 说明此时arr[i]不应该放在i位置，需要调整
    public static int[] sort1(int[] arr) {
        int tmp = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[i];
            while (arr[i] != i + 1) {
                next = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                tmp = next;
            }
        }
        return arr;
    }

    /*
     * 方法二：同一，只是遇到位置需要调整的，直接两个数进行交换
     */
    public static int[] sort2(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                tmp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 3, 4};
        //System.out.println(Arrays.toString(sort1(a)));
        System.out.println(Arrays.toString(sort2(a)));
    }
}
