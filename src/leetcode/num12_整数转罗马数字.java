package leetcode;
/*
 * 《整数转罗马数字》
 */

import java.util.LinkedHashMap;
import java.util.Map;


public class num12_整数转罗马数字 {
    public static String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>() {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (Integer key : map.keySet()) {
                int b = num / key;
                while (b >= 1) {
                    sb.append(map.get(key));
                    b--;
                }
                num = num % key;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
