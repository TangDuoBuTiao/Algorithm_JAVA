package 二叉树;

import java.util.*;

public class InitBinaryTree {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(19);
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
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int a = f.max(node1);
        System.out.println(a);
    }

    //  测试代码***************************************************
    public static int max(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(max(root.left) + root.value, max(root.right) + root.value);
    }
    //*************************************************************
}
