package 玩转算法面试.动态规划;

public class num343_整数拆分 {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解dp[i]
            for (int j = 1; j < i; j++) {
                //分两种情况；
                // 1、把i分成两个数，j*(i-j), 取其中最大值
                dp[i] = Math.max(dp[i], j * (i - j));
                // 2、j乘以继续把(i-j)分割的最大值，这个最大值被保存在dp[i-j]中
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(5));
    }
}
