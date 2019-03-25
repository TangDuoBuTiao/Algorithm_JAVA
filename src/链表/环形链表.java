package 链表;

import java.util.HashSet;

public class 环形链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head){
        HashSet<ListNode> nodeSeen = new HashSet<>();
        while (head != null){
            if(nodeSeen.contains(head)){
                return true;
            }
            else {
                nodeSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
