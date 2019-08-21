package 玩转算法面试.查找;
/*
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
   注意：答案中不可以包含重复的三元组。
    Eg： 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
    [
    [-1, 0, 1],
    [-1, -1, 2]
    ]
 */

import java.util.*;

public class leetCode15_threeSum {

    //排序 + 双指针，最终3个数是nums[i] + l + r = 0
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {  //减2是为了给后面的左右指针留位置
            //首先给nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //l后移，去重
                    while (l < r && nums[l] == nums[l + 1]) { l++; }
                    //r前移, 去重
                    while (l < r && nums[r] == nums[r - 1]) { r--; }
                    l++;
                    r--;
                } else if (sum < 0) {
                    //为了加快速度，减少不必要计算
                    while(l < r && nums[l] == nums[l + 1]){ l++; }
                    l++;
                }else{
                    while(l < r && nums[r] == nums[r - 1]){ r--; }
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
