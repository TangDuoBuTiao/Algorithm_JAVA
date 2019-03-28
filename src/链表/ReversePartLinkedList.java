package 链表;

/*
 反转部分链表，把链表中从from节点到to节点之间的链表反转
 解法：先找到from节点的前一个节点fPre,to节点的后一个节点tPos,先把该反转的反转过来，然后连接在fPre和tPos上。
 */
public class ReversePartLinkedList {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node reversePartLinkedList(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {  //找到fPre 和 tPos的位置
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;  //如果为空，说明反转是从头结点开始，否则，反转从from开始
        Node node2 = node1.next;
        node1.next = tPos;  //from节点之间指向tPos节点

        //下面和反转单链表一样
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        //

        if (fPre != null) {   //fPre为空，说明反转部分包含头结点，直接返回node1
            fPre.next = node1;
            return head;    //不为空的话，直接返回原头结点
        }
        return node1;

    }
}
