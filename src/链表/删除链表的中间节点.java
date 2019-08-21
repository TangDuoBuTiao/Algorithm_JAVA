package 链表;
/*
 删除链表中的中间节点
 解法：使用快慢指针，一个走一步，一个走两步，当走两步的下次为null时，走一步的下一个就是要删除的节点
 */

public class 删除链表的中间节点 {
    //定义单链表节点数据结构
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node per = head;
        Node cur = head.next.next;
        if (per.next != null && cur.next.next != null) {
            per = per.next;
            cur = cur.next.next;
        }
        per.next = per.next.next;
        return head;
    }

}
