package leetcode;

import java.util.Stack;

public class num946_验证栈序列 {
    //思路：模拟栈的弹出，如果popped[j]和此时栈顶元素相等，就弹出栈，j++;
    //     如果popped[j]和栈顶圆元素不相等或者栈为空，就进栈一个元素，i++

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (j < popped.length) {
            if (stack.isEmpty()) {
                stack.push(pushed[i]);
                i++;
            }
            if (popped[j] == stack.peek()) {
                stack.pop();
                j++;
            } else {
                if (i < pushed.length) {
                    stack.push(pushed[i]);
                    i++;
                } else {
                    break;
                }

            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(arr1, arr2));
    }
}
