package 链表;
/*
删除链表中的所有重复的节点。比如1->2->2->3->3->4   删除后为1->4
 */

public class 删除链表中所有重复的节点 {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public  Node removeAllRepeatNodes(Node pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Node Head = new Node(0);
        Head.next = pHead;
        Node pre = Head;
        Node cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.value == cur.next.value) {
                // 找到相同节点部分的最后一个节点
                while (cur.next != null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                pre.next = cur.next;  //pre直接指向最后一个相同节点的下个节点
                cur = cur.next;
            } else {
                pre = pre.next;  //如果没有重复的，pre后移，cur后移
                cur = cur.next;
            }
        }
        return Head.next;  //防止原头结点被删除掉

    }
}
