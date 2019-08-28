package 玩转算法面试.链表;

import java.util.List;

public class num328_奇偶链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //第一个节点是odd,第二个节点是even,
        ListNode odd = head;
        ListNode curOdd = odd;
        ListNode even = odd.next;
        ListNode curEven = even;
        while (curOdd.next != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curEven.next;
            curEven.next = curOdd.next;
            curEven = curOdd.next;
        }
        curOdd.next = even;  //奇数的最后一个连接偶数的第一个
        return head;
    }
}
