package 校招真题2018;
/*
 * 问题描述：
 *        如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。
 *        例如: "1","10101","0101010"都是交错01串。
          小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。
          小易需要你帮帮忙求出最长的这样的子串的长度是多少。
   输入：111101111   ;输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'
 * 输出：3
 */

import java.util.Scanner;

public class 交错01串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.length() == 1) {
            System.out.println(1);
        }
        int res = 1;
        char cur = str.charAt(0);
        int tmp = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != cur) {
                tmp++;
                cur = str.charAt(i);
                res = Math.max(res, tmp);
            } else {
                tmp = 1;
            }
        }
        System.out.println(res);
    }
}
