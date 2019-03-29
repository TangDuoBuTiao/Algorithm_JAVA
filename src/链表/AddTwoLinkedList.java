package 链表;

import java.util.Stack;

/*
 两个单链表生成相加链表，链表整体可以表示一个数，相加完之后也是一个数，用链表表示。
 解法1：把两个链表都压入栈中，弹出栈的时候可保证最低对应位相加，设置进位标准ca,ca=0表没有进位，ca=1表示有进位
 解法2;将两个链表逆序，再相加，加完之后再把原链表逆过来
 */
public class AddTwoLinkedList {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //方法1：利用栈结构求解
    public Node addTwoLinkedList1(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Node cur = head1;
        //遍历链表压入栈中
        while (cur != null) {
            s1.push(cur.value);
            cur = cur.next;
        }
        cur = head2;
        while (cur != null) {
            s2.push(cur.value);
            cur = cur.next;
        }

        int ca = 0;  //进位
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;  //pre节点记录上一次相加生成地方新节点
            node = new Node(n % 10);
            node.next = pre;   //高位相加生成的节点指向pre，达到高位指向低位的目的
            ca = n / 10;
        }
        if (ca == 1) {   //如果最高位有进位，生成一个新的value=1的节点，指向原来的node节点
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node; //返回最高位的节点
    }

    //解法2
    public Node addTwoLinkedList2(Node head1, Node head2) {
        //反转链表
        Node pre1 = reverseList(head1);
        Node pre2 = reverseList(head2);
        //两个反转后的链表相加过程
        int n1 = 0, n2 = 0, n = 0, ca = 0;
        Node node = null;
        Node pre = null;
        while (pre1 != null && pre2 != null) {
            n1 = pre1 != null ? pre1.value : 0;
            n2 = pre2 != null ? pre2.value : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            // 比用栈多的步骤！！！！
            pre1 = pre1 != null ? pre1.next : null;
            pre2 = pre2 != null ? pre2.next : null;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        //恢复两个链表
        head1 = reverseList(pre1);
        head2 = reverseList(pre2);
        return node;
    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
