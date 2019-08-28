package 玩转算法面试.链表;

public class num86_分隔链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode min = null;
        ListNode curMin = null;
        ListNode max = null;
        ListNode curMax = null;
        ListNode cur = head;
        while (cur != null) {
            if (curMin == null && cur.val < x) {  //找到第一个小于x的节点，给min赋值
                curMin = cur;
                min = cur;
            } else if (curMax == null && cur.val >= x) {  //找到第一个大于x的节点，给max赋值
                curMax = cur;
                max = cur;
            } else if (cur.val < x) {  //不是第一次出现，直接指向，然后后移
                curMin.next = cur;
                curMin = cur;
            } else if (cur.val >= x) {
                curMax.next = cur;
                curMax = cur;
            }
            cur = cur.next;  //一定不要忘记移动cur
        }
        if (min == null || max == null) {  //表示x都比链表元素大或者都比链表元素小，min和max有一个没赋值，直接返回head
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
