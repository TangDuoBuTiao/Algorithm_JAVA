package 字符串;
/*         《公式字符串求值》
 * 问题：给定一个字符串str,str表示一个公式，公式里可能有整数、加减乘除符号和左右括号，返回公式的计算结果。
 */

import java.util.Deque;
import java.util.LinkedList;

public class 公式字符串求值 {
    public static int getValue(String exp) {
        return value(exp.toCharArray(), 0)[0];
    }

    public static int[] value(char[] chars, int i) {
        Deque<String> deq = new LinkedList<>();
        int pre = 0;
        int[] bra = null;
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {  //遇到数字
                pre = pre * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {   //遇到 + - * /
                addNum(deq, pre);   //处理之前的数，直接接入到队列中，或者与队列中原来的操作符和数运算后，把结果接入队列
                deq.addLast(String.valueOf(chars[i++]));  //队列中加入运算符号
                pre = 0;
            } else {   //遇到左括号
                bra = value(chars, i + 1);  //计算这个括号内的值
                pre = bra[0];   //括号内的值
                i = bra[1] + 1;  //右括号的下一个位置，也即是下一步该计算的位置
            }
        }
        addNum(deq, pre);   //最后一个数加入队列
        return new int[]{getNum(deq), i};  //返回第一个“部分”的值，和该计算的位置
    }

    public static void addNum(Deque<String> deq, int num) {
        if (!deq.isEmpty()) {  //队列为空，说明没有数加进来，进来的num是第一个数，直接入队
            int cur = 0;
            String top = deq.pollLast();
            if (top.equals("+") || top.equals("-")) {   //如果是加减号，直接入队
                deq.addLast(top);
            } else {    //如果是乘除,和即将入队的num运算后，把结果入队
                cur = Integer.valueOf(deq.pollLast());
                num = top.equals("*") ? cur * num : cur / num;
            }
        }
        deq.addLast(String.valueOf(num));  //直接入队
    }

    public static int getNum(Deque<String> deq) {  //只有加减时的运算
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!deq.isEmpty()) {
            cur = deq.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String str = "48*((70-65)-43)+8*1";
        System.out.println(getValue(str));
    }

}
