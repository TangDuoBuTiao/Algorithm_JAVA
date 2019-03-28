package 链表;

public class InitializeLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.value + "-->");
            } else {
                System.out.println(head.value);
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printLinkedList(node1);
        printLinkedList(reverseLinkedList(node1));
    }

// ***********************************************************测试代码放这里
    public static Node reverseLinkedList(Node head) {
        if (head == null) return null;
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;  //头节点的后一个节点next，
            head.next = pre;   //反向指，head指向head的前一个节点
            pre = head;
            head = next;
        }
        return pre;
    }
//******************************************************************测试代码
}
