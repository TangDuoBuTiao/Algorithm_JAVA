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

        Record1 r = new Record1(node1);
        System.out.print(r.query(node1, node6, node8).value);

    }

    //  测试代码***************************************************
    public static class Record1 {
        private HashMap<Node, Node> map;

        public Record1(Node head) {
            map = new HashMap<>();
            if (head != null) {
                map.put(head, null);
            }
            setMap(head);
        }

        private void setMap(Node head) {   //递归建立哈希表
            if (head == null) {
                return;
            }
            if (head.left != null) {
                map.put(head.left, head);
            }
            if (head.right != null) {
                map.put(head.right, head);
            }
            setMap(head.left);
            setMap(head.right);
        }

        public Node query(Node head, Node o1, Node o2) {
            HashSet<Node> path = new HashSet<>();
            while (map.containsKey(o1)) {
                path.add(o1);         //找到包含o1在内的所有父节点
                o1 = map.get(o1);
            }
            while (!path.contains(o2)) { //判断o2的父节点是不是和o1的父节点重叠
                o2 = map.get(o2);
            }
            return o2;
        }


    }
    //*************************************************************
}
