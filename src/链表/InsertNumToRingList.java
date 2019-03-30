package 链表;

/*
给定一个升序的环形链表，最后一个节点指向头结点，插入一个num，令插入后链表依然有序，返回头结点
 */

public class InsertNumToRingList {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node insertNumToRingList(Node head, int num) {
        Node insertNode = new Node(num);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = insertNode;
        insertNode.next = head;
        return head.value < num ? head : insertNode;
    }
}
