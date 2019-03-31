package 链表;
/*
 按照左右半区的方式重新组合链表
 */

public class RelocateList {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node relocateList(Node head) {
        //三个节点以内的都不变
        if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) {
            return head;
        }
        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        megerLR(head, right);
        return head.next;

    }

    public void megerLR(Node left, Node right) {
        Node next = null;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }
}
