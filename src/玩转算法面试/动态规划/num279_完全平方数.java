package 玩转算法面试.动态规划;

public class num279_完全平方数 {
    public static int numSquares(int n) {
        if(n<= 0){
            return 0;
        }
        if(n <= 3){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++ ){
            dp[i] = i;  //先默认全部由1组成
            for(int t = 2; t * t <= i; t++){
                dp[i] = Math.min(dp[i], dp[i - t * t] + 1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(numSquares(12));
    }
}
