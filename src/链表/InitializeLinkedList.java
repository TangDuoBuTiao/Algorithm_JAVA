package 链表;

import com.sun.xml.internal.ws.api.model.MEP;

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
        Node node4 = new Node(4);
        Node node5 = new Node(5);
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
        //printLinkedList(nodeA);
        printLinkedList(removeLastKthNode(node1, 2));
    }

    // ***********************************************************测试代码放这里

    public static Node removeLastKthNode(Node head, int k) {
        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        cur = head;
        while (k++ != 0) {
            cur = cur.next;
        }
        return cur;
    }
//******************************************************************测试代码
}
