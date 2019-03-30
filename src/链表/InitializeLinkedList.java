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
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(7);
        Node node5 = new Node(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node nodeA = new Node(2);
        Node nodeB = new Node(4);
        Node nodeC = new Node(6);
        Node nodeD = new Node(8);
        Node nodeE = new Node(10);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        printLinkedList(node1);
        printLinkedList(nodeA);
        printLinkedList(mergeTwoList(node1, nodeA));
    }

    // ***********************************************************测试代码放这里

    public static Node mergeTwoList(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node cur = new Node(0);
        Node head = cur;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            cur.next = cur2;
        }
        if (cur2 == null) {
            cur.next = cur1;
        }
        return head.next;
    }

//******************************************************************测试代码
}
