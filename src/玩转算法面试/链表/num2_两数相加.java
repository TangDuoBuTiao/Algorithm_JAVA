package 玩转算法面试.链表;

public class num2_两数相加 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(0);   //结果链表
        ListNode curRes = res;
        boolean flag = false;  //是否进位
        while(cur1 != null || cur2 != null){
            int a = 0;
            int b = 0;
            if(cur1 == null){
                a = 0;
            }else{
                a = cur1.val;
            }
            if(cur2 == null){
                b = 0;
            }else{
                b = cur2.val;
            }
            int sum = a + b;
            if(flag){
                sum++;
            }
            if(sum >= 10){
                sum = sum % 10;
                flag = true;
            }else{
                flag = false;
            }
            ListNode tmp = new ListNode(sum);
            curRes.next = tmp;
            curRes = tmp;
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }
        if(flag){
            ListNode f = new ListNode(1);
            f.next = null;
            curRes.next = f;
        }
        return res.next;
    }
}
