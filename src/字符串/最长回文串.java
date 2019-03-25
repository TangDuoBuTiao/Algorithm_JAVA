package 字符串;

import java.util.Vector;

public class 最长回文串 {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int len = s.length();
        if (len == 1) return s;
        int longest = 1, start = 0;
        Vector<Vector<Integer>> dp = new Vector<>(len);
        for (int i = 0; i < len; i++) {

        }
        String ans = "";

        return ans;
    }
}
