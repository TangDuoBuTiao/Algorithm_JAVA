package 链表;
/*
 环形链表约瑟夫问题，输入：环形链表的头结点head,和报数的值m,
 输出：剩下来存活的节点，且这个节点自己组成环形单向链表
 */

public class JosephusKillNode {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node josephusKillNode(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {    //循环完后last指向链表的最后一个节点（也是head的前一个节点）
            last = last.next;
        }
        int count = 0;
        while (head != last) {  //last一直在head后面，紧随其后，当head走到m个节点时,删除这个节点的方法是，last.next = head.next
            if (count++ == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;   //last向后移
            }
            head = last.next;    //head向后移
        }
        return head;
    }
}
