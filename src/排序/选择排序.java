package 排序;

import java.util.Arrays;

public class 选择排序 {
    public static int[] selectSort(int[] nums) {
        int position = 0;   //记录最小值的位置
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            position = i;
            int tmp = nums[i];
            for (; j < nums.length; j++) {   //在后面未排序的元素中找最小值
                if (nums[j] < tmp) {
                    tmp = nums[j];   //最小值赋给tmp
                    position = j;   // 最小值的位置赋给position
                }
            }
            nums[position] = nums[i];   // 交换未排序的第一个元素和最小值元素的值
            nums[i] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6};
        System.out.println(Arrays.toString(selectSort(a)));
    }
}
