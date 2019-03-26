package 字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class 最长回文串 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        String s = "abbac";
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for(Character key:map.keySet())
        {
            System.out.println("Key: "+key+" Value: "+map.get(key));
        }
    }
}
