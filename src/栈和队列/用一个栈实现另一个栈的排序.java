package 栈和队列;
/*
 用栈实现另一个栈从栈顶到栈底按从大到小的顺序排序
 解法：申请辅助栈help,在stack中执行pop操作，弹出的元素记为cur.
      如果cur小于help栈顶元素，直接入栈；否则判断 如果help不为空，并且cur大于help的栈顶元素，把help中的元素逐一弹出全都压入
      stack中，直到cur小于或等于help的栈顶元素，再讲cur压入help中。
 */

import java.util.Stack;

public class 用一个栈实现另一个栈的排序 {

    public static void SortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();  //申请的辅助栈
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {   //一直保持最大的在help的栈底
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {     //辅助栈的元素反转到stack中。
            stack.push(help.pop());
        }

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(1);
        s.push(2);
        System.out.println(s);
        SortStack(s);
        System.out.println(s);
    }
}
