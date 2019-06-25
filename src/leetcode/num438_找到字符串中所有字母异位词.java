package leetcode;
/*
 问题：给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
      字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
      说明：
       字母异位词指字母相同，但排列不同的字符串。
       不考虑答案输出的顺序。
 输入: s: "cbaebabacd" p: "abc"
 输出: [0, 6]
 */

import java.util.List;
import java.util.ArrayList;

public class num438_找到字符串中所有字母异位词 {

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < pArr.length; i++) {
            hash[pArr[i] - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int l = 0;
        int pLen = pArr.length;
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r] - 'a']--;
            if (hash[sArr[r] - 'a'] >= 0) {  //说明包含了p里面的字符
                count++;
            }
            if (r > pLen - 1) {  //窗口向右移
                hash[sArr[l] -'a']++;
                if(hash[sArr[l] - 'a'] > 0){
                    count--;
                }
                l++;
            }
            if (count == pLen) {
                result.add(l);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p).toString());
    }
}
