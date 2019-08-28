package 玩转算法面试.栈和队列;

import java.util.Stack;

public class num150_逆波兰表达式 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];
            if (tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")) {
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                int res = 0;
                if (tmp.equals("+")) {
                    res = a + b;
                } else if (tmp.equals("-")) {
                    res = a - b;
                } else if (tmp.equals("*")) {
                    res = a * b;
                } else {
                    res = a / b;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(tmp);
            }
        }
        return Integer.valueOf(stack.peek());
    }

}
