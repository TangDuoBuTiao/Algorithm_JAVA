package 校招真题2018.爱奇艺;
/*
 题目描述：一个完整的括号字符串定义规则如下:
        1、空字符串是完整的。
        2、如果s是完整的字符串，那么(s)也是完整的。
        3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
        例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
        牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。
        请问牛牛至少需要添加多少个括号。
 输入：输入包括一行,一个括号序列s,序列长度length(1 ≤ length ≤ 50).
         s中每个字符都是左括号或者右括号,即'('或者')'.
 输出：输出一个整数,表示最少需要添加的括号数
 Eg: (()(()
     2
 */

import java.util.Scanner;
import java.util.Stack;

public class 缺失的括号 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chstr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < chstr.length; i++) {
            if (chstr[i] == '(') {  //如果是左括号，直接进栈
                stack.push(chstr[i]);
            } else if (stack.isEmpty() && chstr[i] == ')') {  //如果栈为空，来了一个右括号，res++
                res++;
            } else if (!stack.isEmpty() && chstr[i] == ')') { //如果栈不为空，来一个右括号，抵消栈里一个左括号
                stack.pop();
            } else {
                continue;
            }
        }
        System.out.println(res + stack.size());
    }
}
