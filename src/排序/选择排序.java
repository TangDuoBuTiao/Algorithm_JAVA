package 排序;

import java.util.Arrays;

public class 选择排序 {
//    public static int[] selectSort(int[] nums) {
//
//        int position = 0;   //记录最小值的位置
//        for (int i = 0; i < nums.length; i++) {
//            int j = i + 1;
//            position = i;
//            int tmp = nums[i];
//            for (; j < nums.length; j++) {   //在后面未排序的元素中找最小值
//                if (nums[j] < tmp) {
//                    tmp = nums[j];   //最小值赋给tmp
//                    position = j;   // 最小值的位置赋给position
//                }
//            }
//            nums[position] = nums[i];   // 交换未排序的第一个元素和最小值元素的值
//            nums[i] = tmp;
//        }
//        return nums;
//    }

    //在长度为n的数组arr中找到最大值的位置
    public static int findMaxPos(int[] arr, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    //选择排序，
    public static void selectionSort(int[] arr, int n) {
        while(n > 1){  //n == 1就不用排序了
            //交换最大值和未排序的最后一个数
            int pos = findMaxPos(arr, n);
            int tmp = arr[pos];
            arr[pos] = arr[n - 1];
            arr[n - 1] = tmp;
            n--;
        }

    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6};
        //System.out.println(findMaxPos(a, 8));
        selectionSort(a, 8);
        System.out.println(Arrays.toString(a));
    }
}
