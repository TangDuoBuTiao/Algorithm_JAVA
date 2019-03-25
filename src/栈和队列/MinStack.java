package 栈和队列;

import java.util.Stack;

/*
 设计一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {   //构造函数中初始化
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("You stack is empty!");
        }
        return this.stackMin.peek();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("You stack is empty!");
        }
        int value = this.stackData.pop();
        if (value == this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return value;
    }

    public static void main(String[]args){
        MinStack s = new MinStack();
        s.push(5);
        s.push(4);
        s.push(7);
        System.out.println(s.getMin());
    }
}




