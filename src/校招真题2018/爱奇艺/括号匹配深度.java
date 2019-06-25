package 校招真题2018.爱奇艺;
/*
 问题描述：一个合法的括号匹配序列有以下定义:
     1、空串""是一个合法的括号匹配序列
     2、如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
     3、如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
     4、每个合法的括号序列都可以由以上规则生成。
    例如: "","()","()()","((()))"都是合法的括号序列
    对于一个合法的括号序列我们又有以下定义它的深度:
     1、空串""的深度是0
     2、如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y)
     3、如果"X"的深度是x,那么字符串"(X)"的深度是x+1
    例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
  输入：输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。
  输出：输出一个正整数,即这个序列的深度。
  Eg:(())
     2
 */

import java.util.Scanner;

public class 括号匹配深度 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chstr = str.toCharArray();
        int res = 0;  //记录最大深度
        int tmp = 0; //记录当前深度
        for (int i = 0; i < chstr.length; i++) {
            if (chstr[i] == '(') {
                tmp++;
            } else {
                tmp--;
            }
            res = Math.max(res, tmp);
        }
        System.out.println(res);
    }
}
