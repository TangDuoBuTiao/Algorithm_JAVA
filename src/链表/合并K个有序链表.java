package 链表;
/*
 * 问题：合并K个有序的单链表
 */

public class 合并K个有序链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
     *方法一：每次找最小值
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        int loc = getMin(lists);
        ListNode min = null;
        if (loc != -1) {
            min = lists[loc];
        } else {
            return newHead.next;
        }
        while (loc != -1) {
            cur.next = min;
            cur = min;
            lists[loc] = min.next;
            loc = getMin(lists);
            if (loc != -1) {
                min = lists[loc];
            }
        }
        return newHead.next;
    }

    public int getMin(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return -1;
        }
        ListNode min = new ListNode(Integer.MAX_VALUE);
        int loc = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (min != null && lists[i].val < min.val) {
                min = lists[i];
                loc = i;
            }
        }
        return loc;
    }

    /*
     * 方法二：两个两个合并有序链表
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return newHead.next;
    }

    public ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode cur = null;
        for (int i = 0; i < lists.length; i++) {
            cur = mergeTwoList(cur, lists[i]);
        }
        return cur;
    }

}
