package leetcode;

import java.util.Arrays;

public class num43_字符串相乘 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int j = len2 - 1; j >= 0; j--) {
            for (int i = len1 - 1; i >= 0; i--) {
                int p1 = i + j;  //进位的下标
                int p2 = i + j + 1;  //个位的下标
                //res[p2]这个位置是上一次计算的进位元素，这次相乘完之后得加上
                int num = Integer.valueOf(num1.charAt(i) - '0') * Integer.valueOf(num2.charAt(j) - '0') + res[p2];
                res[p2] = num % 10;
                res[p1] += num / 10;  //进位，所以是加等
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            if(sb.length() == 0 && res[i] == 0){  //舍弃开头为0
                continue;
            }
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();  //防止出现0乘0的情况
    }
}
