package 链表;
/*
 一种怪异的节点删除方式，
 只给定任意一个节点node，不给头结点，要求删除这个node节点
 解法：把node = node.next ,node= next.next
 */

public class RemoveNodeWeird {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public void removeNodeWeird(Node node) {
        if (node == null) {
            return;
        }
        Node next = node.next;
        if (next == null) {
            throw new RuntimeException("can't remove the last node");
        }
        node.value = next.value;
        node.next = next.next;
    }

}
