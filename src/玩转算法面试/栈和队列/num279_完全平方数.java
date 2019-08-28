package 玩转算法面试.栈和队列;

public class num279_完全平方数 {

    public int numSquares(int n) {
        //1 -> 1, 2 - > 1 + 1, 3 -> 1 + 1 + 1
        if (n <= 3) {
            return n;
        }

        int[] dp = new int[n + 1];
        //dp[0]默认已经是0
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = i;   //先默认全部由1组成
            for (int t = 1; i - t * t >= 0; t++) {
                dp[i] = Math.min(dp[i], dp[i - t * t] + 1);
            }
        }
        return dp[n];
    }
}
