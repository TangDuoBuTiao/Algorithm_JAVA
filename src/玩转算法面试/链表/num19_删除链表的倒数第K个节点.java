package 玩转算法面试.链表;

public class num19_删除链表的倒数第K个节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        //q先移动n+1步
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        //p和q一起移动,当q指向空的时候，p指向待删除节点的前一个节点
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummyHead.next;
    }
}
