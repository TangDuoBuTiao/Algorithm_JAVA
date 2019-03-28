package 链表;
/*
 反转单向和双向链表
 */

//反转单向链表
// 解法:定义头结点的前一个节点pre,
public class ReverseLinkedList {
    public class Node {
        public int value;
        public Node next;

        public Node(int x) {
            this.value = x;
        }
    }

    public static Node reverseLinkedList(Node head) {
        if (head == null) return null;
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;  //头节点的后一个节点next，
            head.next = pre;   //反向指，head指向head的前一个节点
            pre = head;
            head = next;
        }
        return pre;
    }

    //反转双向链表
    public class DoubleNode {
        public int value;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int data) {
            this.value = data;
        }

        public DoubleNode reverseDoublelinkedList(DoubleNode head) {
            if (head == null) return null;
            DoubleNode pre = null;
            DoubleNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;  //反向指
                head.last = next;  //反向指
                pre = head;   //pre向后移到head的位置
                head = next;  //head向后移到next的位置

            }
            return pre;
        }

    }

}
