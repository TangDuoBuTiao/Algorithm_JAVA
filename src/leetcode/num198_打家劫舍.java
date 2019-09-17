package leetcode;
/*
 * 问题：给一个非负数组，不能取相邻的元素，求能取到的最大值
 * 思路：动态规划，建立dp[],dp[i]=max(num[i]+dp[i-2], dp[i-1])
 */


public class num198_打家劫舍 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }
}
