package 二叉树;

import java.util.*;

public class InitBinaryTree {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        //  node7.left = node8;
        InitBinaryTree f = new InitBinaryTree();
        String str = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";   //二叉树序列化结果

        inOrder(node1);

    }

    //  测试代码***************************************************
    public static void inOrder(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                while (head != null) {
                    stack.push(head);
                    head = head.left;
                }
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }
    //*************************************************************
}
