package 校招2020.奇安信;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String find_longest_num_str(String input) {
        char[] c = input.toCharArray();
        if (c.length == 1) {
            if (Character.isDigit(c[0])) {
                return "1/" + c[0];
            } else {
                return "0/";
            }
        }
        int[] dp = new int[c.length];
        if (Character.isDigit(c[0])) {
            dp[0] = 1;
        } else {
            dp[0] = 0;
        }

        for (int i = 1; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        int sum = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= sum) {
                sum = dp[i];
                index = i;
            }
        }
        return  input.substring(index - sum + 1, index + 1);
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = find_longest_num_str(_input);
        System.out.println(String.format("%d/%s", res.length(), res));
    }
}
