package 链表;

import com.sun.xml.internal.ws.api.model.MEP;

import java.util.*;

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
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
       // node5.next = node6;

        Node nodeA = new Node(1);
        Node nodeB = new Node(1);
        Node nodeC = new Node(2);
        Node nodeD = new Node(1);
        Node nodeE = new Node(10);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
       // nodeD.next = nodeE;

        printLinkedList(nodeA);
        System.out.println((isPalindrome(nodeA)));
        //printLinkedList(removeLastKthNode(node1, 5));
        //printLinkedList(reorderList(node1));
    }

    // ***********************************************************测试代码放这里
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node cur = slow;
        Node head2 = reverse(cur);
        cur.next = null;
        while(head2 != null){
            if(head.value != head2.value){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static Node rotateRight(Node head, int k) {
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        //计算链表长度
        Node c = head;
        int len = 0;
        while(c != null){
            len++;
            c = c.next;
        }
        Node pre = dummyHead;
        Node cur = head;
        while(k % len != 0){
            while(cur.next != null){
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = null;
            cur.next = head;
            head = cur;
            pre = dummyHead;
            //dummyHead.next = head;
            k--;
        }

        return head;
    }
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        Node pHead = new Node(0);
        Node cur = pHead;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return pHead.next;
    }


    //翻转单链表
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
//******************************************************************测试代码
}
