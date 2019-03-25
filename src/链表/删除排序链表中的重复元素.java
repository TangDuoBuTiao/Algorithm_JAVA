package 链表;

public class 删除排序链表中的重复元素 {

    // 单链表结构
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        while (cur != null && cur.next != null) {

            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
