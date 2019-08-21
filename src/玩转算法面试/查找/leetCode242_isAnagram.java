package 玩转算法面试.查找;
/*
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：假设题目中只包含小写字母
 */

import java.util.HashMap;

public class leetCode242_isAnagram {
    //使用map方法  57ms
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (map.containsKey(sArr[i])) {
                map.put(sArr[i], map.get(sArr[i]) + 1);
            } else {
                map.put(sArr[i], 1);
            }
        }
        for (int i = 0; i < tArr.length; i++) {
            if (map.containsKey(tArr[i])) {
                map.put(tArr[i], map.get(tArr[i]) - 1);
            } else {
                return false;
            }
        }
        for (char key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    //使用ascii码对应数组下标方法  6ms
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            freq[sArr[i] - 'a']++;
            freq[tArr[i] - 'a']--;
        }
        for (int j = 0; j < 26; j++) {
            if(freq[j] != 0){
                return false;
            }
        }
        return true;
    }
}
