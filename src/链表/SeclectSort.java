package 链表;
/*
 给定一个无序的单链表的头结点head,实现单链表的选择排序
 */

public class SeclectSort {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node secletSort(Node head) {
        Node tail = null;   //有序部分的最后一个节点
        Node small = null;
        Node smallPre = null;
        Node cur = head;
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {    //如果返回的是null ==> small = cur ,
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;  //如何samll=cur , cur直接后移
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;  //tail指向small(把新的最小值挂在有序部分的最后)
            }
            tail = small; //tail后移至当前有序部分的最后一个

        }

        return head;
    }
    //返回最小值的前一个元素。比如9->2->4->1->7   返回4->1->7
    public Node getSmallestPreNode(Node head) {   //如果第一个就是最小值，返回null
        Node small = head;
        Node cur = head;
        Node smallPre = null;
        Node pre = null;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
