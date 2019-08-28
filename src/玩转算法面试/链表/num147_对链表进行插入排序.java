package 玩转算法面试.链表;

public class num147_对链表进行插入排序 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /*
     * 每次需要向前面插入时，都要从链表头开始比较，
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = null;

        while (head != null && head.next != null) {
            if(head.val <= head.next.val){
                head = head.next;
                continue;
            }
            pre = dummyHead;
            while(pre.next.val <= head.next.val){
                pre = pre.next;
            }
            //先把head之后的待排序元素删除掉
            ListNode cur = head.next;
            head.next = cur.next;
            //再把该元素插入前面排序部分
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummyHead.next;
    }
}
