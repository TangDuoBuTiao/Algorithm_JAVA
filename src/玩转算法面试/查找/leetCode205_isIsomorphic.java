package 玩转算法面试.查找;
/*
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    输入: s = "egg", t = "add"
    输出: true
    *
    * 输入: s = "foo", t = "bar"
      输出: false
  说明:
  你可以假设 s 和 t 具有相同的长度。
 */

import java.util.HashMap;
import java.util.HashSet;
public class leetCode205_isIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (map.containsKey(sArr[i])) {
                if(map.get(sArr[i]) != tArr[i]){
                    return false;
                }
            }else{
                map.put(sArr[i], tArr[i]);
            }
        }
        HashSet<Character> set = new HashSet<>();
        for(Character key : map.keySet()){
            set.add(map.get(key));
        }
        if(map.size() != set.size()){
            return false;
        }
        return true;
    }
}
