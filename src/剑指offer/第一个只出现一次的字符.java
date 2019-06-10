package 剑指offer;

import java.util.LinkedHashMap;

public class 第一个只出现一次的字符 {

    public static int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] charStr = str.toCharArray();
        for (int i = 0; i < charStr.length; i++) {
            if (map.containsKey(charStr[i])) {
                map.put(charStr[i], -1);
            } else {
                map.put(charStr[i], i);
            }
        }
        int ans = -1;
        for (Character key : map.keySet()) {
            if (map.get(key) != -1) {
                ans = map.get(key);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }
}
