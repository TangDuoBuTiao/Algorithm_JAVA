package 二叉树;

import java.util.Stack;

public class InitBinaryTree {
    public static class Node {
        public int value;
        public Node left;  //左子树
        public Node right; //右子树

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        InitBinaryTree f = new InitBinaryTree();
        f.posOrderUnRecur(node1);

    }

    //  测试代码***************************************************
    public void posOrderUnRecur(Node head) {
        //只用一个栈实现
        System.out.println("非递归实现后序遍历：");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    head = c;
                }
            }
        }

    }

    //*************************************************************
}
