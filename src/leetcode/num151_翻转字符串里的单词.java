package leetcode;

import java.util.Arrays;

public class num151_翻转字符串里的单词 {
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].equals("")) {
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good  example";
        System.out.println(reverseWords(s));
    }
}
