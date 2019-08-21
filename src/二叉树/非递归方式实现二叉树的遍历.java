package 二叉树;
/*
非递归方式实现二叉树的前序，中序，后序遍历
 */

import java.util.Stack;

public class 非递归方式实现二叉树的遍历 {

    //非递归的方式前序遍历
    public void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            if (!stack.isEmpty()) {    //先进栈一个头结点，只要栈不为空，就一直循环
                head = stack.pop();   //每次循环先出栈一个，后边先进右子树，后进左子树。保证出的时候先出左，后出右
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    //非递归方式中序遍历
    public void inOrderUnRecur(Node head) {
        System.out.println("非递归方法的中序遍历：");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while (!stack.isEmpty() || cur != null) {  //只要栈或游标不为null,就一直循环
                if (cur != null) {   //cur不为空，就进栈，一直找左子树，直到为null.
                    stack.push(cur);
                    cur = cur.left;
                } else {                       //cur为null后，出栈一个，打印出来，cur指向右子树
                    cur = stack.pop();
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
    }

    //非递归方法后序遍历,定义两个遍历h,c。h:最近一次弹出并打印的节点; c:当前的栈顶元素
    public void posOrderUnRecur(Node head) {
        //只用一个栈实现
        System.out.println("非递归实现后序遍历：");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {   //左右子树有存在，都还没被（弹出去过）遍历过
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {   //右子树存在，但没被遍历过（可能存在左子树，但已经被访问过）
                    stack.push(c.right);
                } else {                                         //左右子树都被遍历过或者都不存在
                    System.out.println(stack.pop().value + " ");
                    head = c;  //c是刚被弹出来的，所以head = c
                }
            }
        }

    }

}
