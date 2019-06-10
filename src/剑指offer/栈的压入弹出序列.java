package 剑指offer;
/*
 * 问题： 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是不是栈的弹出序列。
 * 解法： 使用一个辅助栈，从头到尾遍历第一个序列，在每一次遍历中，先压入栈，再判断栈顶元素是否和第二个序列的头元素相同
 *       ①如果相同，出栈，指针指向第二个序列的下一个元素，并判断当前栈是否为空，如果为空,直接break
 *       ②如果不同，直接继续压入第一个序列的元素
 *       最后判断辅助栈是否为空，空的话返回true， 否则返回false.
 */

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (stack.peek() == popA[j]) {
                stack.pop();
                j++;
                if(stack.isEmpty()){
                    break;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        System.out.println(IsPopOrder(a,b));
    }
}
