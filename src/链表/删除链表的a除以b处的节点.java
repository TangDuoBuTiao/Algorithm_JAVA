package 链表;

/*
 给定链表头结点head,整数a和整数b，实现删除位于a/b处节点的函数
 解法：设链表长度为n，(a*n)/b 再向上取整，就是要删除的节点位置
 */
public class 删除链表的a除以b处的节点 {
    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node removeNodeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0, len = 0;
        Node cur = head;
        while (cur != null) {   //计算链表长度
            len++;
            cur = cur.next;
        }
        n = (int) Math.ceil((double) (a * len) / (double) b);   //计算删除的位置
        if (n == 1) {
            return head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {  //当n减到1时，cur指向n前面的一个节点，跳出while
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
