package leetcode;
/*
 问题描述：给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
         在执行上述操作后，找到包含重复字母的最长子串的长度。
    注意:
    字符串长度 和 k 不会超过 104。
    Eg:输入: s = "AABABBA", k = 1
       输出: 4
    解释:
    将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
    子串 "BBBB" 有最长重复字母, 答案为 4。

 */

public class num424_替换后的最长重复字符 {
    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] sArr = s.toCharArray();
        int[] hash = new int[26];
        int l = 0;
        int maxCount = 0;
        int res = 0;
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r] - 'A']++;
            maxCount = Math.max(maxCount, hash[sArr[r] - 'A']);
            while (r - l + 1 - maxCount > k) {
                hash[sArr[l] - 'A']--;
                l++;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int a = characterReplacement("ABABABBA", 2);
        System.out.println(a);
    }
}
