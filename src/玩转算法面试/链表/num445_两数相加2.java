package 玩转算法面试.链表;

public class num445_两数相加2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode res = add(l1, l2);
        return reverse(res);
    }

    public ListNode add(ListNode l1, ListNode l2){
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        boolean flag = false;
        ListNode res = new ListNode(0);
        ListNode curRes = res;
        while(cur1 != null || cur2 != null){
            int a = 0;
            int b = 0;
            if(cur1 != null){
                a = cur1.val;;
            }
            if(cur2 != null){
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

    public ListNode reverse(ListNode head){
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
