package leetcode;

public class num86_分隔链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode min = null;
        ListNode curMin = null;
        ListNode max = null;
        ListNode curMax = null;
        ListNode cur = head;
        while (cur != null) {
            if (curMin == null && cur.val < x) {
                curMin = cur;
                min = cur;
            }else
            if (curMax == null && cur.val >= x) {
                curMax = cur;
                max = cur;
            }else
            if (cur.val < x) {
                curMin.next = cur;
                curMin = cur;
            }else
            if (cur.val >= x) {
                curMax.next = cur;
                curMax = cur;
            }
            cur = cur.next;
        }
        if(min == null || max == null){  //表示x都比链表元素大或者都比链表元素小，min和max有一个没赋值，直接返回head
            return head;
        }
        curMax.next = null;   //切断最后一个大元素的next
        curMin.next = max;  //最后一个小的指向大的元素的第一个
        if (min == head) {
            return head;
        } else {
            return min;
        }
    }
}
