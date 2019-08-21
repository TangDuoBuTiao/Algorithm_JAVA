package 递归和动态规划;
/*《字符串的交错组成》
 * 问题：给定三个字符串str1、str2和aim,判断aim是否由str1和str2交错组成，同时aim中保持str1和str2中的字符顺序
 * 解法：建立dp[M+1][N+1]布尔类型矩阵，dp[i][j]表示aim[0,.,i+j-1]能否被str1[0,.i-1]和str[0,.,j-1]交错组成
 *      1.dp[0][0] = true，aim为空时，当然可以被str1为空串和str2为空串交错组成。
 *      2.dp[][]的第一列，dp[i][0]表示aim[0,.,i-1]能否只被str1[0,.,i-1]交错组成，如果全部可以，返回true,否则返回false
 *      3.dp[][]第一行同第一列
 *      4.对于未知dp[i][j]，分为三种情况
 *          ①：dp[i-1][j]表示aim[0,.,i+j-2]能否被str1[0,.,i-2]和str2[0,.,j-1]交错组成，如果可以，
 *             那么如果再有str1[i-1]等于aim[i+j-1]，令dp[i][j] = true
 *          ②：dp[i][j-1]表示aim[0,.,i+j-2]能否被str1[0,.,i-1]和str2[0,.,j-2]交错组成，如果可以,
 *             那么如果再有str2[j-1]等于aim[i+j-1], 令dp[i][j] = true
 *          ③：不满足①和②，就是false
 */

public class 字符串的交错组成 {
    public static boolean stringCross(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        if (ch1.length + ch2.length != chaim.length) {
            return false;
        }
        boolean[][] dp = new boolean[ch1.length + 1][ch2.length + 1];
        dp[0][0] = true;
        //填写dp第一列
        for (int i = 1; i <= ch1.length; i++) {
            if (ch1[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        //填写dp第一行
        for (int j = 1; j <= ch2.length; j++) {
            if (ch2[j - 1] != chaim[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i - 1] == chaim[i + j - 1] && dp[i - 1][j] ||
                        ch2[j - 1] == chaim[i + j - 1] && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[ch1.length][ch2.length];
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "123";
        String aim = "a1b2c3";
        System.out.println("aim是否交错组成："+stringCross(str1, str2, aim));

    }
}
