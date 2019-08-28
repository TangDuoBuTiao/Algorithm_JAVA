package 玩转算法面试.链表;

public class num92_翻转链表2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mpre = null;   //要翻转部分的前一个节点
        ListNode npos = null;    //翻转部分的后一个节点
        //下面这段代码是定位mpre指针和npos的位置
        ListNode cur = head;
        int index = 1;
        while(cur != null){
            if (index == m - 1){
                mpre = cur;
            }
            if(index == n + 1){
                npos = cur;
                break;
            }
            cur = cur.next;
            index++;
        }
        
        //接下来要翻转（mpre,npos）之间的节点
        ListNode pre = mpre == null ? head : mpre.next;   //这一句要格外注意！！
        cur = pre.next;
        pre.next = npos;
        ListNode next = null;
        while (cur!= npos) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //pre指向的是翻转部分的最后一个节点
        //翻转完成之后，判断mpre为null,来确定返回节点
        if(mpre != null){
            mpre.next = pre;
            return head;
        }
        return pre;
    }
}
