package 链表;

import java.util.Stack;

/*
 两个单链表生成相加链表，链表整体可以表示一个数，相加完之后也是一个数，用链表表示。
 解法1：把两个链表都压入栈中，弹出栈的时候可保证最低对应位相加，设置进位标准ca,ca=0表没有进位，ca=1表示有进位
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
            node.next = pre;   //高位相加生成的节点指向pre，达到高位指向地位的目的
            ca = n / 10;
        }
        if (ca == 1) {   //如果最高位有进位，生成一个新的value=1的节点，指向原来的node节点
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node; //返回最高位的节点
    }
}
