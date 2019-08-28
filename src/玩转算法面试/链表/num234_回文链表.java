package 玩转算法面试.链表;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class num234_回文链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new LinkedList<>();
        ListNode cur = head;
        while(cur != null){
            dq.offerFirst(cur.val);
            cur = cur.next;
        }
        while(!dq.isEmpty() && dq.size() > 1){
            if(dq.pollFirst() != dq.pollLast()){
                return false;
            }
        }
        return true;
    }

    //进阶
    public boolean isPalindrome2(ListNode head)
    {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow.next;
        ListNode head2 = reverse(cur);
        cur.next = null;
        while(head2 != null){
            if(head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head= next;
        }
        return pre;
    }
}
