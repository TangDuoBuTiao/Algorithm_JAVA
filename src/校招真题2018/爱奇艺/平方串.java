package 校招真题2018.爱奇艺;
/*
 问题描述：如果一个字符串S是由两个字符串T连接而成,即S = T + T, 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
        牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。
        换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串。
 输入:输入一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串只包括小写字符。
 输出：输出一个正整数,即满足要求的平方串的长度。
 Eg:frankfurt
    4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 平方串 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        int len = str.length();
        int res = 0;
        for (int i = 1; i < len; i++) {
            String str1 = str.substring(0, i);
            String str2 = str.substring(i, len);
            res = Math.max(res, getdp(str1, str2));
        }
        System.out.println(res);

    }

    public static int getdp(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {  //填充第一列
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++) {   //填充第一行
            dp[0][j] = Math.max(dp[0][j - 1], str2[j] == str1[0] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }
}
