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

        System.out.print(f.countNodeNumOfCBT(node1));

    }

    //  测试代码***************************************************
    //主函数
    public int countNodeNumOfCBT(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    //递归函数
    public int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {  //说明当前节点的左子树是满二叉树，
            return ((1 << (h - level)) + bs(node.right, level + 1, h));
        } else {                                //当前节点的右子树是满的
            return ((1 << (h - level - 1)) + bs(node.left, level + 1, h));
        }
    }

    public int mostLeftLevel(Node head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }
    //*************************************************************
}
