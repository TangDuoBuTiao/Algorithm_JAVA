package 玩转算法面试.链表;


public class num143_重排链表 {
    public class ListNode {
        ListNode next = null;
        int val;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找到中间节点为slow
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur1 = head;
        ListNode c = slow.next;
        slow.next = null;
        ListNode cur2 = reverse(c);
        c.next = null;
        ListNode next1 = null;
        ListNode next2 = null;
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

        System.out.println(head);
    }

    //翻转单链表
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
