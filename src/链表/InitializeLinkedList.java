package 链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class InitializeLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.value + "-->");
            } else {
                System.out.println(head.value);
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node nodeA = new Node(9);
        Node nodeB = new Node(2);
        Node nodeC = new Node(4);
        Node nodeD = new Node(1);
        Node nodeE = new Node(7);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        printLinkedList(node1);
        //printLinkedList(nodeA);
        printLinkedList(removeRepeatNodes(node1));
    }

    // ***********************************************************测试代码放这里
    public static Node removeRepeatNodes(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (!set.contains(cur.value)) {
                set.add(cur.value);
                pre = cur;
                cur = cur.next;
                pre.next = cur;
            } else {
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return head;
    }
//******************************************************************测试代码
}
