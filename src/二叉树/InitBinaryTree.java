package 二叉树;

import 玩转算法面试.链表.num445_两数相加2;

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
       // node7.left = node8;
        InitBinaryTree f = new InitBinaryTree();
        String str = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";   //二叉树序列化结果
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        List<String> a = f.bianryTreePaths(node1);
        System.out.println(a);

    }

    //  测试代码***************************************************
    public static List<String> bianryTreePaths(Node root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.value));
            return res;
        }

        List<String> lefts = bianryTreePaths(root.left);
        for (int i = 0; i < lefts.size(); i++) {
            res.add(root.value + "->" + lefts.get(i));
        }

        List<String> rights = bianryTreePaths(root.right);
        for (int i = 0; i < rights.size(); i++) {
            res.add(root.value + "->" + rights.get(i));
        }
        return res;
    }
    //*************************************************************
}
