package 校招2020.携程;

import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode partition(ListNode head, int m) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode min = null;
        ListNode curMin = null;
        ListNode max = null;
        ListNode curMax = null;
        ListNode cur = head;
        while (cur != null) {
            if (curMin == null && cur.val < m) {
                curMin = cur;
                min = cur;
            } else if (curMax == null && cur.val >= m) {
                curMax = cur;
                max = cur;
            } else if (cur.val < m) {
                curMin.next = cur;
                curMin = cur;
            } else if (cur.val >= m) {
                curMax.next = cur;
                curMax = cur;
            }
            cur = cur.next;
        }
        if (min == null || max == null) {
            return head;
        }
        curMax.next = null;
        curMin.next = max;
        if (min == head) {
            return head;
        } else {
            return min;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }

}

