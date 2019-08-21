package 排序;

import java.util.Arrays;

public class 插入排序 {
//    public static int[] insertSort(int[] nums) {
//        int tmp = 0;
//        for (int i = 1; i < nums.length; i++) {
//            int j = i - 1;
//            tmp = nums[i];
//            for (; j >= 0 && nums[j] > tmp; j--) {
//                nums[j + 1] = nums[j];
//            }
//            nums[j + 1] = tmp;
//        }
//        return nums;
//    }

    //无序的第一个数向有序部分插入，倒着遍历有序部分
    public static void insert(int arr[], int n) {
        int key = arr[n];
        int i = n;
        while (arr[i - 1] > key) {
            arr[i] = arr[i - 1];
            i--;
            if (i == 0) {
                break;
            }
        }
        arr[i] = key;
    }

    //
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            insert(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
