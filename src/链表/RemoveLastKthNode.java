package 链表;
/*
 删除单链表或双链表中倒数第k个节点
 解法：让链表从头走到尾，每移动一步，k值减1，会得到一个k的变化数组arr[]
      如果arr[]的末尾元素 > 0，说明k值比链表长，直接返回原链表即可；
      如果arr[]的末尾元素 = 0，说明倒数第k个节点就是头结点，直接让第二个节点作为链表的头结点返回即可；
      如果arr[]的末尾元素 < 0，说明第k个在链表中间，要删除某个节点，需要找到这个节点之前的节点，让其指向下下个节点即可。
         再让链表从头走，每移动一步，让k值+1，如果k = 0,这个节点就是需要找的节点。
 */

//单向链表
public class RemoveLastKthNode {
    //定义链表节点数据结构
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node removeLastKthNode(Node head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            head = head.next;   //让第二个节点作为头结点
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    //双向链表
    public class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public DoubleNode removeLastKthDoubleNode(DoubleNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;   //head指向第二个节点，把第二个节点变成头结点
            head.last = null;   //再修改第二个节点的last为null.
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {   //当k=0后，cur指向倒数第k个节点的前一个节点
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;  //newNext是倒数第k个节点的后一个节点
            cur.next = newNext; //前一个节点，直接指向后一个节点 <==> 删除倒数第k个节点
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }

}
