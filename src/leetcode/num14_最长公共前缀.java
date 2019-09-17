package leetcode;

//substring()  前闭后开

public class num14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {   //遍历第一个字符串的每个字符
            for (int j = 0; j < strs.length; j++) {    //遍历每个字符串
                if (strs[j].length() > i) {   //确保这个待比较的字符串长度够长
                    if (strs[j].charAt(i) != strs[0].charAt(i)) {  //每个字符串的第i个和第一个字符串的第i个比较
                        return strs[0].substring(0, i);  //不相等的话，就返回第一个字符串的前i个字符
                    }
                } else {  //待比较字符长度不够，直接返回前i个字符
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];  //如果遍历完第一个字符串，没有不相等的，就返回第一个字符串
    }
}
