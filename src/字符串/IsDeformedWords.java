package 字符串;
/*                      《判断两个字符串是否互为变形词》
 * 问题：给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样吗，并且每种字符出现的次数也一样，
 *      那么str1和str2互为变形词。
 */

import java.util.HashMap;

public class IsDeformedWords {
    public static boolean isDeformedWords(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        if (chs1.length != chs2.length) {
            return false;
        }
        for (int i = 0; i < chs1.length; i++) {
            if (!map.containsKey(chs1[i])) {
                map.put(chs1[i], 1);
            } else {
                map.put(chs1[i], map.get(chs1[i]) + 1);
            }
        }
        for (int j = 0; j < chs2.length; j++) {
            if (map.containsKey(chs2[j])) {
                map.put(chs2[j], map.get(chs2[j]) - 1);
            } else {
                return false;
            }
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "1124335";
        String str2 = "2413351";
        System.out.println(isDeformedWords(str1, str2));
    }
}
