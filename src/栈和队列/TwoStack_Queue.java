package 栈和队列;
/*
 两个栈实现一个队列；
     入队时，直接压入stack1
     出队时，判断stack2是否为空，如果为空，则将stack1中的元素倒入stack2中，
                               否则，直接弹出stack2中的元素。
 */

import java.util.Stack;

public class TwoStack_Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public TwoStack_Queue()  //构造函数，初始两个栈

    {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void add(int newNum) {   //入队
        stack1.push(newNum);
    }

    public int poll() {    //出队
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("You Queue is empty.");
        } else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {  //返回队头元素
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("You Queue is empty.");
        } else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        TwoStack_Queue t = new TwoStack_Queue();
        t.add(1);
        t.add(2);
        t.add(3);
        System.out.println("入队元素1,2,3");
        System.out.println("队头元素：" + t.peek());
        System.out.println("出队：" + t.poll());
        System.out.println("队头元素：" + t.peek());
    }


}
