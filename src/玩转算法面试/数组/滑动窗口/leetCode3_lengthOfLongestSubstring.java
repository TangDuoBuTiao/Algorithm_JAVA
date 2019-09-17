package 玩转算法面试.数组.滑动窗口;
/*
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

public class leetCode3_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] freq = new int[256];
        int l = 0;
        int r = -1;  //滑动窗口是s[l,..,r]
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[(int) s.charAt(r + 1)] == 0) {  //r向右试探，如果无重复情况
                r++;
                freq[(int) s.charAt(r)]++;
            } else {  //有重复
                freq[(int) s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "dvdi";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
