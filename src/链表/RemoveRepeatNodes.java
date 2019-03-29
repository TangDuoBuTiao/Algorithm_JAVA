package 链表;

import java.util.HashSet;

/*
 给定一个无序的单链表的头结点head,删除其中值重复出现的
 */
public class RemoveRepeatNodes {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 使用HashSet
    public Node removeRepeatNodes1(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (!set.contains(cur.value)) {
                set.add(cur.value);
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
