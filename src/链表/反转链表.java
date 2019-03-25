package 链表;

public class 反转链表 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseListIterative(ListNode head) {
        if (head == null) return null;
        ListNode p = head.next, tmp = null, t = head;
        while (p != null) {
            tmp = p;
            p = p.next;
            t.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
