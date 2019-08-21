package 玩转算法面试.数组.滑动窗口;
/*
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 输入: S = "ADOBECODEBANC", T = "ABC"
   输出: "BANC"
 * 没有答案返回""
 */

public class leetCode76_minWindow {
    public static String minWindow(String s, String t) {
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] freq = new int[256];
        for (int i = 0; i < tArr.length; i++) {  //把t字符位置加1
            freq[tArr[i]]++;
        }
        int l = 0;
        int count = tArr.length;
        int min = sArr.length + 1;
        for (int r = 0; r < sArr.length; r++) {
            freq[sArr[r]]--;  //遍历到统一减1
            if (freq[sArr[r]] >= 0) {  //出现t中的字符
                count--;
            }
            //左窗口位置必须有t中的字符
            while (l < r && freq[sArr[l]] < 0) {
                freq[sArr[l]]++;  //左窗口一直右移，直到
                l++;
            }
            if (count == 0 && r - l + 1 <= min) {
                min = Math.min(min, r - l + 1);
                res = s.substring(l, r + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
