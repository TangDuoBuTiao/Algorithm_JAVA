package 链表;

import java.util.Stack;

/*
 给定一个单链表，使得每K个节点之间逆序，最后不足K个不逆序
 */
public class ReverseKNodes {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 方法一：使用栈结构
    public Node reverseKNodes1(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = resign1(stack, pre, next);
                newHead = newHead == head ? cur : newHead;   //用第一组反转后的头结点为整个链表的头结点，后面就不改了
            }
            cur = next;
        }
        return newHead;

    }

    public Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {   //上一组最后一个节点指向这组的第一个节点
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

}
