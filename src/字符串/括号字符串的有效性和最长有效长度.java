package 字符串;
/*
 * 问题：给定一个字符串，判断是不是整体有效的括号字符串
 * 解法：1、遍历str,如果发现有不是'('或')',返回false；
 *      2、遍历每一个字符，都检查到目前为止'('和')'的数量，如果')'更多，返回false
 *      3、遍历完，检查'('和')'的数量，如果相等，返回true, 否则返回false。
 *
 * 补充问题：给定一个括号字符串str,返回最长的有效括号子串
 */

import java.util.Arrays;

public class 括号字符串的有效性和最长有效长度 {
    //主问题
    public static boolean isValid(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        int lNum = 0;
        int rNum = 0;
        char[] chas = str.toCharArray();
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != '(' && chas[i] != ')') {
                return false;
            } else if (chas[i] == '(') {
                lNum++;
            } else {
                rNum++;
            }
            if (rNum > lNum) {
                return false;
            }
        }
        if (lNum == rNum) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 补充问题：使用动态规划，dp[i]值的含义是str[0,.,i]中必须以字符str[i]结尾的最长有效括号子串长度
     *         dp[0] = 0,只含有一个字符肯定不是有效字符串，长度为0
     *         str[i] = '(', 有效字符串必然是以')'结尾的，所以dp[i] = 0
     *         str[i] = ')',
     */
    public static int maxLength(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == ')') {
                pre = i - dp[i - 1] - 1;   //和当前chas[i]有可能匹配的位置
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }


    public static void main(String[] args) {
        String str = "(()())";
        //System.out.println(isValid(str));
        System.out.println(maxLength(str));
    }
}
