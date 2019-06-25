package leetcode;
/*
 题目描述：给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 Eg:输入: S = "ADOBECODEBANC", T = "ABC"
    输出: "BANC"
 说明：
 如果 S 中不存这样的子串，则返回空字符串 ""。
 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */

public class num76_最小覆盖子串 {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < tArr.length; i++) {
            hash[tArr[i]]++;
        }
        int count = tArr.length;
        int l = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r]]--;   //进hash时统一减
            if (hash[sArr[r]] >= 0) {
                count--;
            }
            while (l < r && hash[sArr[l]] < 0) {  //左窗口一直向右移动到t中字符出现
                hash[sArr[l]]++;    //出hash时统一加
                l++;
            }
            if (count == 0 && r - l + 1 < min) {
                min = r - l + 1;
                result = s.substring(l, r + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
