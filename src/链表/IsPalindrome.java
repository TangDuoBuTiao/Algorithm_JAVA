package 链表;
/*
 判断一个链表是否是一个回文结构
 */

import java.util.Stack;

public class IsPalindrome {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Boolean isPalindrome(Node head) {
        if (head == null) {
            throw new RuntimeException("Your LinkedList is null.");
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
