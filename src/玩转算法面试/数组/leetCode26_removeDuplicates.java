package 玩转算法面试.数组;
/*
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 注意：你不需要考虑数组中超出新长度后面的元素。
 */

import java.util.Arrays;

public class leetCode26_removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int k = 0;  //循环不变量，保证区间[0,k]都没有重复元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
