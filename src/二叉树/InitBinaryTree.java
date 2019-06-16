package 二叉树;

import java.util.*;

import 二叉树.PrintTreeByLevel;

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
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res = f.print(node1);

        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    //  测试代码***************************************************
    public ArrayList<ArrayList<Integer>> print(Node pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Node last = pRoot;
        Node nLast = null;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            pRoot = queue.poll();
            if (pRoot.left != null) {
                queue.offer(pRoot.left);
            }
            if (pRoot.right != null) {
                nLast = pRoot.right;
                queue.offer(pRoot.right);
            }
            list.add(pRoot.value);
            if (pRoot == last && !queue.isEmpty()) {
                last = nLast;
                nLast = null;
                res.add(new ArrayList(list));
                list.clear();
            }
        }
        res.add(new ArrayList(list));
        return res;
    }
    //*************************************************************
}
