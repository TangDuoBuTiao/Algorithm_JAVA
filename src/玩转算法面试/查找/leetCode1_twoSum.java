package 玩转算法面试.查找;
/*
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */

import java.util.HashMap;

public class leetCode1_twoSum {
    //查找表, 使用map<元素值，下标>，对于每个元素a, 再查找表中找target-a
    //s使用map，元素重复怎么办？
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  //遍历到元素nums[i]时，在map中查找target-nums[i]
            if (!map.containsKey(complement)) {  //这样保证如果出现重复元素，不会被覆盖
                map.put(nums[i], i);
            }else{
                res[0] = map.get(complement);
                res[1] = i;
                return res;
            }
        }
        throw new RuntimeException("no answer");
    }
}
