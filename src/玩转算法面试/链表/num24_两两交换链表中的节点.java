package 玩转算法面试.链表;

public class num24_两两交换链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        // p->node1->node2->next
        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            //交换位置
            p.next = node2;
            node2.next = node1;
            node1.next = next;
            //移动p指针
            p = node1;  //node1此时指的是两个元素的第二个
        }
        return dummyHead.next;
    }
}
