package leetcode;

public class num300_最长上升子序列 {
//    public static int lengthOfLIS(int[] nums) {
//        int[] tails = new int[nums.length];
//        int res = 0;
//
//        for (int k = 0; k < nums.length; k++) {
//            int i = 0, j = res;
//            while (i < j) {
//                int m = (i + j) / 2;
//                if (tails[m] < nums[k]) {
//                    i = m + 1;
//                } else {
//                    j = m;
//                }
//            }
//            tails[i] = nums[k];
//            if (res == j) {
//                res++;
//            }
//        }
//        return res;
//    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {   //遍历数组
            dp[i] = 1;  //自己有序
            for (int j = i - 1; j >= 0; j--) {   //找到i位置之前的比nums[i]小的
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 21, 18};
        System.out.println(lengthOfLIS(arr));
    }

}
