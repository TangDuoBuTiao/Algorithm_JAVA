package leetcode;
/*
 * 判断needle字符串是不是haystack字符串里面，返回出现的首字母位置
 */

public class num28_实现strStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] hay = haystack.toCharArray();
        char[] ned = needle.toCharArray();
        int i = 0;
        int j = 0;
        while (j < ned.length && i < hay.length) {
            if (hay[i] == ned[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == ned.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}
