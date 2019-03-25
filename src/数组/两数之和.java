package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (hm.containsKey(c)) {
                return new int[]{hm.get(c), i};
            }
            hm.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 6, 7, 8};
        System.out.println(Arrays.toString(twoSum(a, 15)));
    }
}
