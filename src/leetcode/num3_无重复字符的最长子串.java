package leetcode;
/*
 问题描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 Eg: 输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

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

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
