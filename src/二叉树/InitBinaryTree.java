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
        System.out.print(f.isCBT(node1));

    }

    //  测试代码***************************************************
    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node l = null;
        Node r = null;
        boolean leaf = false;

        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;

            // leaf = true 表明有节点没有右子树，当这层再有空的孩子节点
            if (leaf && (l != null || r != null) || (l == null && r != null)) {
                return false;
            }
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            } else {   //没有右子树，就增加了不是完全二叉树的概率
                leaf = true;
            }

        }
        return true;
    }
    //*************************************************************
}
