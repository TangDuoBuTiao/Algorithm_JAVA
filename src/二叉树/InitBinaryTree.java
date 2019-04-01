package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
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
        String str = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";   //二叉树序列化结果
        System.out.println(f.serialByBFS(node1));

    }

    //  测试代码***************************************************
    public String serialByBFS(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        String res = head.value + "!";
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
                res += head.left.value + "!";
            } else {
                res += "#!";
            }
            if (head.right != null) {
                queue.offer(head.right);
                res += head.right.value + "!";
            } else {
                res += "#!";
            }
        }
        return res;
    }
    //*************************************************************
}
