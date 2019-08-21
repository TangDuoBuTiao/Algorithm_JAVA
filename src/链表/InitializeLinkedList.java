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
        printLinkedList(oddEvenList(node1));
        //printLinkedList(removeLastKthNode(node1, 5));
        //printLinkedList(reorderList(node1));
    }

    // ***********************************************************测试代码放这里
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node curOdd = odd;
        Node even = odd.next;
        Node curEven = even;
        while (curOdd.next != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curEven.next;
            curEven.next = curOdd.next;
            curEven = curOdd.next;
        }
        curOdd.next = even;  //奇数的最后一个连接偶数的第一个
        return head;
    }


    public static Node reorderList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找到中间节点为slow
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node node = head;
        while(node.next != slow){
            node = node.next;
        }
        node.next = null;
        Node cur1 = head;
        Node cur2 = reverse(slow);
        Node pHead = new Node(0);
        Node next1 = null;
        Node next2 = null;
        pHead.next = cur1;
        while (cur1 != null && cur2 != null) {
            //保存下一个节点
            next1 = cur1.next;
            next2 = cur2.next;
            //指向
            cur1.next = cur2;
            cur2.next = next1;
            //后移
            cur1 = next1;
            cur2 = next2;

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
