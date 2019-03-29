package 链表;

/*
给定一个链表和指定的值num,删除这个链表中所有值为num的节点
 */
public class RemoveDesignationValue {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node removeDesignationValue(Node head, int num) {
        if (head.value == num) {   //如果第一个元素删除，head后移一位
            head = head.next;
        }
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (cur.value != num) {
                pre = cur;
                cur = cur.next;
                pre.next = cur;
            } else {
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
