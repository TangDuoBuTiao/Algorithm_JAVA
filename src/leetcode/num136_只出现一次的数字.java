package leetcode;

import java.util.HashSet;

public class num136_只出现一次的数字 {
    //使用额外空间
    //23ms   44MB
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int res = 0;
        for (Integer s : set) {
            res = s;
        }
        return res;
    }

    //异或操作   1ms  42.3MB
    //2 ^ 3 ^ 2 ^ 4 ^ 4 等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
    public int singleNumber2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res  = res ^ nums[i];
        }
        return res;
    }
}
