package 排序;
/*
 * 思想：分治
 */

import java.util.Arrays;

public class 归并排序 {
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void merge(int[] arr, int L, int mid, int R) {
        int[] tmp = new int[arr.length];   //辅助数组
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        //比较左右两部分的元素，哪个小，把那个元素填入tmp中
        while (p1 <= mid && p2 <= R) {
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //哪个没有遍历完，直接挂在tmp后边,两个while只执行一个
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            tmp[i++] = arr[p2++];
        }
        //把最终的排序结果复制给原数组
        i = 0;
        while (L <= R) {
            arr[L++] = tmp[i++];
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 4, 5, 7, 1, 3, 6, 2};
        System.out.println("原数组：" + Arrays.toString(a));
        mergeSort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }
}
