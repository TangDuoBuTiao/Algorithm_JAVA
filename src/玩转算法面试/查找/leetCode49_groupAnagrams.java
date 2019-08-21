package 玩转算法面试.查找;
/*
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
   输出:
   [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
   ]
   说明：
   所有输入均为小写字母。
   不考虑答案输出的顺序。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetCode49_groupAnagrams {
    //hashMap
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String strNew = getKey(strs[i]);
            if (map.containsKey(strNew)) {
                List<String> list = map.get(strNew);
                list.add(strs[i]);
                map.put(strNew, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(strNew, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;

    }

    //把字符串用以ascii表示数组的下标，然后1，0之间加上#,组成字符串
    public String getKey(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(freq[i]);
            sb.append("#");
        }
        return sb.toString();
    }
}
