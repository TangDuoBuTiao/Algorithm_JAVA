package 玩转算法面试.链表;

public class num203_移除链表元素 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode cur = pHead;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}
