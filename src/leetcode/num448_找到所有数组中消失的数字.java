package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num448_找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % len] += len;
        }
        System.out.println(Arrays.toString(nums));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= len) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 5, 5, 7, 7, 8};
        System.out.println(findDisappearedNumbers2(arr));
    }
}
