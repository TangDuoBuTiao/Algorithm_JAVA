package 递归和动态规划;
/*
 * 问题：给定两个字符串str1和str2, 返回两个字符串的最长公共子串
 * 经典解法：使用时间复杂度和空间复杂度为O(M*N)的方式建立dp[M][N]
 *         1.dp[M][N]的第一列中填的值是str1[i]和str2[0]对应位置，如果相同就为1，否则为0
 *         2.dp[M][N]的第一行同第一列，str2[i]和str1[0]对应位置，如果相同就为1，否则为0
 *         3.dp[i][j]的填入分两种情况：
 *            ①：如果str1[i] != str2[j],说明把str1[i]和str[j]当作公共子串的末尾元素是不可能的，dp[i][j] = 0
 *            ②：如果str1[i] == str2[j], dp[i][j] = dp[i-1][j-1] + 1
 */

public class 最长公共子串问题 {
    /*
     * 方法1：构建dp矩阵，空间复杂度O(M*N)
     */
    public static int[][] getdp1(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        //填写dp的第一列
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        //填写dp的第一行
        for (int j = 0; j < str2.length; j++) {
            if (str2[j] == str1[0]) {
                dp[0][j] = 1;
            }
        }
        //填写dp[i][j]
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
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

    //根据dp[][]得到最长公共子串
    public static String lcst1(String str1, String str2) {
        if (str1 == null || str1.equals("") || str2 == null || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp1(chs1, chs2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    /*
     * 方法2：空间复杂度O(1),因为计算dp[i][j]的值，只需要记录dp[i-1][j-1]即可
     */
    public static String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = 0;   //斜线开始位置的行
        int col = chs2.length - 1;    //斜线位置开始的列
        int end = 0;    //最大长度更新时，记录子串结尾位置
        int max = 0;    //记录最大长度
        while (row < chs1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < chs1.length && j < chs2.length) {
                if (chs1[i] != chs2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                //记录最大值以及结束字符的位置
                if (len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {   //说明col还可以向左移动
                col--;
            } else {      //说明col已经移动到了0位置，接下来开始向下移动
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "bebcd";
        System.out.println(lcst2(str1, str2));
    }
}
