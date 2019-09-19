package leetcode;

public class num142_找到链表入环节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //找到链表入环节点，给的链表不确定有没有环，没环返回null
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {  //直到相遇
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow != fast){   //判断是否有环
            return null;
        }
        fast = head;  //fast从头开始走
        while (slow != fast) {   //fast和slow相遇就是入环节点
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
