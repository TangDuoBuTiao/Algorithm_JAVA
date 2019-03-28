package 链表;
/*
 判断一个链表是否是一个回文结构
 原始解法： 把链表的节点存进栈里面，存完后，链表从头，栈从栈顶依次比较元素是否相等，如果全相等，就是回文结构，否则不是。
           空间复杂度O(N)
 进阶1解法：把链表的右半部分压入栈，拿链表的左半部分和栈里的元素比较
           空间复杂度O(N/2)
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

    //原始解法
    public static Boolean isPalindrome1(Node head) {
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

    //进阶1
    public static Boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Node> stack = new Stack<>();
        Node curFast = head;
        Node curSlow = head.next;
        while (curFast.next != null && curFast.next.next != null) {
            stack.push(curSlow);
            curSlow = curSlow.next;
            curFast = curFast.next.next;
        }
        while (curSlow != null) {
            stack.push(curSlow);
            curSlow = curSlow.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
