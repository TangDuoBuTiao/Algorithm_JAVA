package 链表;

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
        Node node4 = new Node(5);
        Node node5 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printLinkedList(node1);
        printLinkedList(node2);
        printLinkedList(twosortlist(node1,node2));
    }

    // ***********************************************************测试代码放这里
    public static Node twosortlist(Node head1, Node head2) {
        if (head1 == null && head2 != null) return head2;
        else if (head2 == null && head1 != null) return head1;
        else if (head1 == null && head2 == null) return null;
        Node head = null;
        if (head1.value < head2.value) {
            head = head1;
            head.next = twosortlist(head1.next, head2);
        } else {
            head = head2;
            head.next = twosortlist(head1, head2.next);
        }
        return head;
    }
//******************************************************************测试代码
}
