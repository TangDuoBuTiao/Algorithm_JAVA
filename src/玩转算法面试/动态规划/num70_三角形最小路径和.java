package 玩转算法面试.动态规划;


import java.util.List;

public class num70_三角形最小路径和 {

    public int minimumTotal(List<List<Integer>> triangle) {
        //第i行有i + 1个元素
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        //最小值在最后一行
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;

    }

}
