package 玩转算法面试.数组.滑动窗口;
/*
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 */

import java.util.ArrayList;
import java.util.List;

public class leetCode438_findAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] freq_p = new int[26];
        for (int i = 0; i < pArr.length; i++) {  //先把p字符串的位置加1
            freq_p[pArr[i] - 'a']++;
        }
        int[] freq_s = new int[26];
        int l = 0;
        int r = -1; //滑动窗口:s[l,r]
        while (r + 1 < sArr.length) {
            r++;
            freq_s[sArr[r] - 'a']++;
            if (r - l + 1 > pArr.length) {
                freq_s[sArr[l] - 'a']--;
                l++;
            }
            if (r - l + 1 == pArr.length && same(freq_s, freq_p)) {
                res.add(l);
            }
        }
        return res;
    }

    public boolean same(int[] s, int[] p) {
        for (int i = 0; i < 26; i++) {
            if(s[i] != p[i]){
                return false;
            }
        }
        return true;
    }
}
