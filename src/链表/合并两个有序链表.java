package 链表;

public class 合并两个有序链表 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        System.out.println(dummyHead);
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if(l1 == null){
            cur.next = l2;
        }
        else{
            cur.next = l1;
        }
        return dummyHead.next;

    }


}
