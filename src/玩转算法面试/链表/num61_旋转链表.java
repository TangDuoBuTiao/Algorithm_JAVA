package 玩转算法面试.链表;

public class num61_旋转链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //计算链表长度
        ListNode c = head;
        int len = 0;
        while(c != null){
            len++;
            c = c.next;
        }
        ListNode pre = dummyHead;
        ListNode cur = head;
        while(k % len != 0){
            while(cur.next != null){
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = null;
            cur.next = head;
            head = cur;
            pre = dummyHead;
            dummyHead.next = head;
            k--;
        }

        return head;
    }
}
