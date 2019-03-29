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
        printLinkedList(nodeA);
        printLinkedList(addTwoLinkedList2(node1, nodeA));
    }

    // ***********************************************************测试代码放这里
    public static Node addTwoLinkedList2(Node head1, Node head2) {
        //反转链表过程，pre1是head1反转后的结果，pre2是head2反转后的结果
        Node next = null;
        Node pre1 = null;
        while (head1 != null) {
            next = head1.next;
            head1.next = pre1;
            pre1 = head1;
            head1 = next;
        }
        Node pre2 = null;
        while (head2 != null) {
            next = head2.next;
            head2.next = pre2;
            pre2 = head2;
            head2 = next;
        }
        //两个反转后的链表相加过程
        int n1 = 0, n2 = 0, n = 0, ca = 0;
        Node node = null;
        Node pre = null;
        while (pre1 != null && pre2 != null) {
            n1 = pre1 != null ? pre1.value : 0;
            n2 = pre2 != null ? pre2.value : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            pre1 = pre1 != null ? pre1.next : null;
            pre2 = pre2 != null ? pre2.next : null;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;

    }
//******************************************************************测试代码
}
