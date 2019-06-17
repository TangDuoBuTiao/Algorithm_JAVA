package 校招真题2018.爱奇艺;
/*
 问题描述：牛牛得到一个长度为n的整数序列V,牛牛定义一段连续子序列的幸运值为这段子序列中最大值和次大值的异或值
        (次大值是严格的次大)。牛牛现在需要求出序列V的所有连续子序列中幸运值最大是多少。请你帮帮牛牛吧。
 输入：第一行一个整数n,即序列的长度。(2<= n <= 100000)
      第二行n个数，依次表示这个序列每个数值V[i], (1 ≤ V[i] ≤ 10^8)且保证V[1]到V[n]中至少存在不同的两个值.
 输出：输出一个整数,即最大的幸运值
 Eg: 5
     5 2 1 4 3
     7
 */

import java.util.Scanner;
import java.util.Stack;

public class 幸运子序列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            //stack 维持一个单调递减的栈，栈顶元素最大
            while (!stack.isEmpty() && x >= stack.peek()) {  //如果x大，那么栈顶元素就变为次大
                res = Math.max(res, x ^ stack.pop());
            }
            //当前元素为次大值，栈顶元素为最大值
            if(!stack.isEmpty()){
                res = Math.max(res, x ^ stack.peek());
            }
            stack.push(x);
        }
        System.out.println(res);
    }
}
