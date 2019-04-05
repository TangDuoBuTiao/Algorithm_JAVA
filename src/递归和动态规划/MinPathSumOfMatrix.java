package 递归和动态规划;
/*
 * 问题：给定一个二维矩阵m(M*N)，从m[0][0]开始，每一步只能向右走或者向下走，当走到右下角时，令走过的路径上的加和最小。
 * 做法1：空间和时间复杂度都是O(M*N)
 *       ①先建立一个dp矩阵，矩阵的第一行和第一列是加和，其他位置dp[i][j]是min{dp[i-1][j], dp[i][j-1]}
 *       ②得到dp矩阵中每个位置都是走到当前位置加和最小的，最后返回dp[row-1][col-1]
 *
 * 做法2：不用dp[][]二维数组，使用大小为min{M,N}的数组,如果行<列，从左向右更新每列；如果行>列，从上向下更新每行。
 */

public class MinPathSumOfMatrix {

    //做法一：
    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {    //填充dp[][]的第一行
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        for (int j = 1; j < col; j++) {    //填充dp[][]的第一列
            dp[j][0] = dp[j - 1][0] + m[j][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }

        return dp[row - 1][col - 1];

    }

    //做法2 空间复杂度较小到O(min{M,N}) ，时间复杂度不变。
    public static int minPathSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int more = Math.max(m.length, m[0].length);  //行与列较大的为more
        int less = Math.min(m.length, m[0].length);  //行与列较小的为less
        int[] dp = new int[less];
        boolean rowmore = m.length >= m[0].length;
        dp[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            dp[i] = dp[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            dp[0] = dp[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return dp[less - 1];
    }


    public static void main(String[] args) {
        int[][] m = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}};
        System.out.print(minPathSum2(m));
    }
}
