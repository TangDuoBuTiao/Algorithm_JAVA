package leetcode;

import java.util.ArrayList;
import java.util.List;

public class num139_单词拆分 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        char[] c = s.toCharArray();
        String str = "";
        for (int i = 0; i < c.length; i++) {
            str += c[i];
            if (wordDict.contains(str)) {
                str = "";
            }
        }
        return str.equals("") ? true : false;
    }
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aa");
        System.out.println(wordBreak("aaaa", list));
    }
}
