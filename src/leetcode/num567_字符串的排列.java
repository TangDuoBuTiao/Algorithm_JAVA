package leetcode;
/*
 问题描述：给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
         换句话说，第一个字符串的排列之一是第二个字符串的子串。
 Eg:输入: s1 = "ab" s2 = "eidbaooo"
    输出: True
    解释: s2 包含 s1 的排列之一 ("ba").
 */

public class num567_字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < s1Arr.length; i++) {
            hash[s1Arr[i]]++;
        }
        int l = 0;
        int count = 0;
        int s1Len = s1Arr.length;
        for (int r = 0; r < s2Arr.length; r++) {
            hash[s2Arr[r]]--;
            if (hash[s2Arr[r]] >= 0) {
                count++;
            }
            if (r >= s1Len) {
                hash[s2Arr[l]]++;
                if(hash[s2Arr[l]] > 0){
                    count--;
                }
                l++;
            }
            if(count == s1Len){
                return true;
            }
        }
        /*窗口长度不固定写法
        for (int r = 0; r < s2Arr.length; r++) {
            hash[s2Arr[r]]--;
            if (hash[s2Arr[r]] == 0) {
                count++;
            } else {
                while(l < r && hash[s2Arr[r]] < 0){
                    hash[s2Arr[l]]++;
                    if(hash[s2Arr[l]] > 0){
                        count--;
                    }
                    l++;
                }
            }
            if (count == s1Len) {
                return true;
            }
        }
         */
        return false;
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
