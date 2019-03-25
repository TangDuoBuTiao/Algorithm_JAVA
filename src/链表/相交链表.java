package 链表;

import java.util.HashSet;

public class 相交链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeSeen = new HashSet<>();
        while (headA != null && headB != null) {
            if (nodeSeen.contains(headA)) {
                return headA;
            } else if (nodeSeen.contains(headB)) {
                return headB;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
