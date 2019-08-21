package 字符串;
/*   《删除多余字符得到字典序最小的字符串》
 * 问题：给定一个全是小写字母的字符串str, 删除多余字符，使得每种字符只保留一个，并让最终结果字符串的字典序最小。
 * Eg: str = "cabc", 删掉第一个'c'，得到"abc", 是所有结果字符串中字典序最小的。
 */


import java.util.*;

public class 删除多余字符得到字典序最小的字符串 {
    public static void removeDuplicateLetters(String str) {
        char[] chas = str.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < chas.length; i++) {
            map[chas[i] - 'a']++;
        }
        char[] res = new char[26];
        int index = 0;
        int left = 0;
        int right = 0;
        while (right != chas.length) {
            /*
            *
            *
            * 未完成
             */

        }
        System.out.println(Arrays.toString(map));
    }

    public static void main(String[] args) {
        String str = "baacbaccac";
        removeDuplicateLetters(str);
    }
}
