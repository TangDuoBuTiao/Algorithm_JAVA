package 递归和动态规划;
/*
 * 问题：给定两个字符串str1和str2，返回这两个字符串的最长公共子序列
 * 解法：建立dp[][]矩阵，行数为str1.length = M; 列数为str2.length = N,
 *      dp[i][j]的含义是str1[0,.,i]和str2[0,.,j]的最长公共子序列的长度
 *      1.首先确定dp的第一行和第一列，第一行找到str2[0,.,N-1]中和str1[0]相同的元素，以这个元素开始后面的都为1，（说明从这个元素开始，有了公共的序列）
 *        第一列的填法同第一行，先找到str1[0,.,M-1]中和str2[0]相同的元素，从这个元素开始，后面的都为1。
 *      2.dp[i][j]的填法分为三种情况：
 *        ①dp[i][j] = dp[i-1][j]
 *        ②dp[i][j] = dp[i][j-1]
 *        ③如果str[i] = str[j], 还可能是(dp[i-1][j-1] + 1)
 *        最后，选这三种情况中最大的作为dp[i][j]的值
 */

public class LongestCommonSubseq {
    //构建dp矩阵
    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        //填充第一列
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        //填充第一行
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str2[j] == str1[0] ? 1 : 0);
        }
        //填充dp[i][j]
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%-4d", dp[i][j]);
            }
            System.out.println();
       }
        return dp;
    }

    public static String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int m = chs1.length - 1;  //向上走的游标
        int n = chs2.length - 1;  //向左走的游标
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }


    public static void main(String[] args) {
        String str1 = "1A2B3C";
        String str2 = "B1D23C";
        System.out.println(lcse(str1, str2));
    }
}
