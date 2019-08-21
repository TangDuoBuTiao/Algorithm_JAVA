package 递归和动态规划;
/*
 * 问题：最小编辑代价，给定两个字符串str1和str2,再给定编辑代价,ic表示插入代价，dc表示删除代价，rc表示替换代价
 *      返回将str1编辑成str2的最小代价。
 * 解法：建立dp[M+1][N+1]矩阵，dp[0][0]表示str1的空串编辑为str2的空串，代价为0
 *      dp[][]的第一行，表示str1空串编辑为str2[j],就是空串插入问题，编辑代价为dp[0][j] = ic*j
 *      dp[][]的第一列，表示str1[i]编辑为str2的空串，就是删除问题，编辑代价为dp[i][0] = dc*i
 *      dp[i][j]的编辑代价表示str1[0,.i-1]编辑为str2[0,.,j-1]的编辑代价，其填入分为三种情况：
 *       ①：dp[i][j-1]+ic,这是str1的当前子串和str2的当前子串的最后一个字符之前的子串经过调整后已经匹配了，
 *         又多了一个str2的字符，为了匹配，得插入，代价是ic;
 *       ②：dp[i-1][j]+dc,str1当前子串的最后一个字符之前的子串和str2当前子串匹配了，
 *         str1又多了一个字符，为了匹配上，得删除，代价是dc;
 *       ③：dp[i-1][j-1]+rc, str1和str2当前子串的最后一个字符之前的子串都匹配，如果str1[i] = str2[j],
 *         则编辑代价不变，为dp[i-1][j-1],否则需要把str[i]替换成str[j],代价为dp[i-1][j-1]+rc。
 */

public class 最小编辑代价 {
    /*
     * parameter str1:原字符串
     * parameter str2:要编辑成为的字符串
     * parameter   ic:插入字符代价
     * parameter   dc:删除字符代价
     * parameter   rc:替换字符代价
     */
    public static int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null && str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length + 1;   //dp的行
        int col = chs2.length + 1;   //dp的列
        int[][] dp = new int[row][col];
        //填写dp[][]的第一列
        for (int i = 1; i < row; i++) {
            dp[i][0] = dc * i;
        }
        //填写dp[][]的第一行
        for (int j = 1; j < col; j++) {
            dp[0][j] = ic * j;
        }
        //填写dp[i][j]
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%-4d", dp[i][j]);
            }
            System.out.println();
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        String str1 = "ab12cd3";
        String str2 = "abcdf";
        int ans = minEditCost(str1, str2, 5, 3, 2);
        System.out.println("最小编辑代价：" + ans);
    }

}
