package 链表;

import java.util.HashMap;
/*
 复制含有随机指针节点的链表
 */

public class 复制含有随机指针节点的链表 {

    public class Node {
        public int value;
        public Node next;
        public Node rand;   //某个节点的一个指针，随意指向其他节点

        public Node(int data) {
            this.value = data;
        }
    }

    //使用HashMap方法,<key:原节点，value:复制的节点>
    public Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //进阶方法：不使用HashMap，只用有限的几个变量来完成
    public Node copyListWithRand2(Node head) {
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;
        //设置复制节点的rand指针
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        //拆分
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }


}
