package 玩转算法面试.栈和队列;

import java.util.List;

public class num23_合并K个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = merge2Lists(lists[i], res);
        }
        return res;
    }

    //合并2个有序链表
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode next1 = l1.next;
                cur.next = l1;
                cur = l1;
                l1 = next1;
            } else {
                ListNode next2 = l2.next;
                cur.next = l2;
                cur = l2;
                l2 = next2;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummyHead.next;
    }

}
