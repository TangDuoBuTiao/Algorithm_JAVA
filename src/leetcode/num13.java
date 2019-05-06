package leetcode;
/*                      《罗马数字转整数》
 * 字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

 *特殊情况：
        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
 */

import java.util.HashMap;

public class num13 {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
            put('1', 4);
            put('2', 9);
            put('3', 40);
            put('4', 90);
            put('5', 400);
            put('6', 900);
        }};
        if (s.contains("IV")) {
            s = s.replace("IV", "1");
        }
        if (s.contains("IX")) {
            s = s.replace("IX", "2");
        }
        if (s.contains("XL")) {
            s = s.replace("XL", "3");
        }
        if (s.contains("XC")) {
            s = s.replace("XC", "4");
        }
        if (s.contains("CD")) {
            s = s.replace("CD", "5");
        }
        if (s.contains("CM")) {
            s = s.replace("CM", "6");
        }
        char[] chas = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chas.length; i++) {
            ans += map.get(chas[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }
}
