package 字符串;
/*          《回文最少分割数》
 * 给定一个字符串str, 返回把str全部切成回文子串的最小分割数。
 * 解法：定义一个动态规划数组dp[i]，其含义是str[i,.,len-1]至少需要切割几次，从右向左计算每一个dp[i]的值，最后的dp[0]就是结果。
 *      dp[i]的值计算过程如下：
 *         1.假设i <= j < len ,如果str[i,.,j]是回文串，那么dp[i] = dp[j+1] + 1。其含义是既然str[i,.,j]是回文串，
 *           那么它自己可以作为分割的部分，剩下的部分str[j+1,.,len-1]继续做最经济的分割, 而dp[i+1]的值的含义正好是
 *           str[j+1,.,len-1]的最少回文分割数。
 *         2.根据步骤1的方式，让j在i到len-1上做枚举，dp[i] = min{dp[j+1]+1,(且str[i,.,j]必须是回文串)}
 *      如何快速的判断str[i,j]是不是回文串?
 *         1.str[i,.,j]由1个字符组成；是
 *         2.str[i,.,j]由2个字符组成，且2个字符相等。是
 *         3.str[i+1,.,j-1]是回文串，且str[i] == str[j]；是
 */

public class MinCutWhisperSubstring {
    public static int minCut(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int len = chas.length;
        int[] dp = new int[len + 1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (chas[i] == chas[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String str = "acdcdcdad";
        System.out.println(minCut(str));
    }

}
