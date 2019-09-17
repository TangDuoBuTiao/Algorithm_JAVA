package leetcode;

public class num160_相交链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = 0;
        int lenb = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != null) {
            lena++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            lenb++;
            cur2 = cur2.next;
        }
        int diff = 0;
        boolean flag = false;
        if (lena >= lenb) {
            diff = lena - lenb;
            flag = true;
        } else {
            diff = lenb = lena;
        }
        cur1 = headA;
        cur2 = headB;
        if (flag) {
            while (diff > 0) {
                diff--;
                cur1 = cur1.next;
            }
            while (cur1 != null && cur2 != null && cur1.val != cur2.val) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            while (diff > 0) {
                diff--;
                cur2 = cur2.next;
            }
            while (cur1 != null && cur2 != null && cur1.val != cur2.val) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
    }
}
