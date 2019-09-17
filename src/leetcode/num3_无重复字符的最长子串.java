package leetcode;
/*
 问题描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 Eg: 输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

import java.util.HashMap;

public class num3_无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();
        int[] hash = new int[256];
        int l = 0;
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r]]--;
            while (l < r && hash[sArr[r]] < -1) {
                hash[sArr[l]]++;
                l++;
            }
            if (l <= r && r - l + 1 > max) {
                max = r - l + 1;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int[] dp = new int[c.length];
        dp[0] = 1;
        map.put(c[0], 1);
        for (int i = 1; i < c.length; i++) {
            if(!map.containsKey(c[i])){
                map.put(c[i], 1);
                dp[i] = dp[i - 1] + 1;
            }else{
                map.clear();
                dp[i] = 1;
            }
        }
        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }

}
