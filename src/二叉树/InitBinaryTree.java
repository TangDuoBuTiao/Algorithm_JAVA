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
        node7.left = node8;
        InitBinaryTree f = new InitBinaryTree();
        String str = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";   //二叉树序列化结果

        System.out.print(f.getMaxDistance(node1));

    }

    //  测试代码***************************************************
    //建立递归函数返回的类型
    public class ReturnType {
        public int height;
        public int maxDist;

        public ReturnType(int height, int maxDist) {
            this.height = height;
            this.maxDist = maxDist;
        }
    }

    //递归函数(后序遍历)
    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDist = Math.max(leftData.height + rightData.height + 1,
                Math.max(leftData.maxDist, rightData.maxDist));

        return new ReturnType(height, maxDist);
    }

    public int getMaxDistance(Node head) {
        return process(head).maxDist;
    }
    //*************************************************************
}
