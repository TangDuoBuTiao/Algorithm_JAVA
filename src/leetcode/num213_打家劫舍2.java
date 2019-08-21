package leetcode;
/*
 * 问题：给一个非负环形数组，数组元素首尾相连，不能取相邻的元素，求能取到的最大值
 * 思路：动态规划，分2种情况，建立dp1[]和dp2[], dp[i]=max(num[i]+dp[i-2], dp[i-1])
 */

public class num213_打家劫舍2 {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int len = nums.length;
            int[] dp1 = new int[len];
            int[] dp2 = new int[len];
            //第一种情况，不抢第一个
            dp1[0] = 0;
            dp1[1] = nums[1];
            for (int i = 2; i < len; i++) {
                dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
            }
            //第二种情况，不抢最后一个
            dp2[0] = nums[0];
            dp2[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len - 1; i++) {
                dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
            }
            return Math.max(dp1[len - 1], dp2[len - 2]);  //!!!不抢最后一个是len-2位置最大
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(rob(arr));
    }
}
