package 玩转算法面试.查找;
/*
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
   输入: pattern = "abba", str = "dog cat cat dog"
   输出: true
   注意：你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */

import java.util.HashMap;
import java.util.HashSet;
public class leetCode290_wordPattern {

    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        char[] pArr = pattern.toCharArray();
        String[] sArr = str.split(" ");
        if (pArr.length != sArr.length) {
            return false;
        }
        for (int i = 0; i < pArr.length; i++) {
            if (map.containsKey(pArr[i])) {
                if (!map.get(pArr[i]).equals(sArr[i])) {
                    return false;
                }
            } else {
                map.put(pArr[i], sArr[i]);
            }
        }
        HashSet<String> set = new HashSet<>();  //为了避免出现，不同的字符对应相同的字符串
        for (char key : map.keySet()) {
            set.add(map.get(key));
        }
        if(map.size() != set.size()){
            return false;
        }
        return true;
    }
}
