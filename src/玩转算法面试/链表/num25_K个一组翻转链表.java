package 玩转算法面试.链表;

public class num25_K个一组翻转链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 2) {
            return head;
        }
        //设置虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //pre和end开始先指向dummyHead
        ListNode pre = dummyHead;
        ListNode end = dummyHead;  //指向待翻转链表的最后一个元素
        while (end.next != null) {
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;   //断开end，让start-end之间的链表进行翻转
            pre.next = reverse(start);
            start.next = next;

            //移动到start,因为start指向的是下一组待翻转链表的前一个节点
            pre = start;
            end = start;
        }
        return dummyHead.next;
    }

    //正常的翻转单链表
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
