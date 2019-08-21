package 玩转算法面试.数组;
/*
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */

import java.util.Arrays;

public class leetCode80_removeDuplicates2 {

    public static int removeDuplicates(int[] nums) {
        int k = 2;
        for (int i = k; i < nums.length; i++) {
           if(nums[k - 2] != nums[i]){
               nums[k] = nums[i];
               k++;
           }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
    }
}
