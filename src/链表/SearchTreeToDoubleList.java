package 链表;
/*
将搜索二叉树转换为双向链表
 */

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class SearchTreeToDoubleList {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //方法1：生成一个队列，记为queue,按照中序遍历将每个节点放入queue中
    //      从queue中依次弹出节点，按照弹出顺序重连所有的节点。
    public Node convert1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty()) {    //一个一个出队，right指针相当于next,left指针相当于last
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }
//中序遍历，把二叉树中的节点添加到队列中
    public void inOrderToQueue(Node head, Queue<Node> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

}
