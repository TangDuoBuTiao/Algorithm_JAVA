package 字符串;
/*  《找到字符串的最长无重复字符子串》
 * 问题：给定一个字符串str,返回str的最长无重复字符子串的长度，实现时间复杂度O(N)的方法
 */

public class MaxUniqueSubStr {
    public static int maxUnique(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {  //map[]位置代表字符，值代表最近一次出现的位置。
            map[i] = -1;
        }
        int len = 0;  //记录最长无重复子串的长度
        int pre = -1;  //当前遍历到str[i], pre表示必须以str[i-1]结尾时，最长无重复子串开始位置的前一个位置。
        int cur = 0;   //遍历当前字符，所能构成的最长无重复子串长度，cur = i - pre;
        for (int i = 0; i < chas.length; i++) {
            pre = Math.max(pre, map[chas[i]]);  //如果chas[i]之前出现过，那么最长无重复子串开始位置的前一个位置就是之前出现过chas[i]的位置。
            cur = i - pre;
            len = Math.max(len, cur); //更新len的值
            map[chas[i]] = i;  //更新/记录chas[i]这个字符最近出现的位置
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "aabcb";
        System.out.println(maxUnique(str));
    }
}
