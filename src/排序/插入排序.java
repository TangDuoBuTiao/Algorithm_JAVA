package 排序;

import java.util.Arrays;

public class 插入排序 {
    public static int[] insertSort(int[] nums) {
        int tmp = 0;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            tmp = nums[i];
            for (; j >= 0 && nums[j] > tmp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76};
        System.out.println(Arrays.toString(insertSort(a)));
    }
}
