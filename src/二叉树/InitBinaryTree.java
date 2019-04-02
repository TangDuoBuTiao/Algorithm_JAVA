package 二叉树;

import java.util.*;

import 二叉树.Node;

public class InitBinaryTree {

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
        String str = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";   //二叉树序列化结果
        System.out.print(f.isSBT_UnRecur(node1));

    }

    //  测试代码***************************************************
    public boolean isSBT_UnRecur(Node head) {
        if (head != null) {
            int last = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    if (cur.value <= last) {
                        return false;
                    }
                    last = cur.value;
                    cur = cur.right;
                }
            }
            return true;
        }
        return true;
    }
    //*************************************************************
}
