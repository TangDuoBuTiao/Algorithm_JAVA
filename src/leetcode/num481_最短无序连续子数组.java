package leetcode;

import java.util.Arrays;

public class num481_最短无序连续子数组 {
    public static int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length;
        int end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(findUnsortedSubarray(arr));
    }
}
