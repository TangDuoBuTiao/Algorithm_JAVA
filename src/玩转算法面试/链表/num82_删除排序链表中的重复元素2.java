package 玩转算法面试.链表;

public class num82_删除排序链表中的重复元素2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode cur = head;
        ListNode pre = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {  //如果不为空，且一直重复，就一直找
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {   //如果没有发现重复元素，两个指针正常后移一步
                pre = pre.next;
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}
