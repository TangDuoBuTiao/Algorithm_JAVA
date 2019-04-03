package 二叉树;
/*
"Z"字形打印二叉树
 */

import java.util.Deque;
import java.util.LinkedList;

public class PrintTreeByZigzag {

    public void printTreeByZigzag(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> dq = new LinkedList<>();
        boolean lr = true;    //true:从左到右   false：从右到左
        int level = 1;
        Node last = head;
        Node nLast = null;
        dq.offerFirst(head);
        print(level++, lr);
        while (!dq.isEmpty()) {
            if (lr) {                           //从左到右方向：头出尾进
                head = dq.pollFirst();
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dq.offerLast(head.left);
                }
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dq.offerLast(head.right);
                }
            } else {                          //从右到左方向：尾出头进
                head = dq.pollLast();
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dq.offerFirst(head.right);
                }
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dq.offerFirst(head.left);
                }
            }
            System.out.print(head.value + " ");
            if (head == last && !dq.isEmpty()) {
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                print(level++, lr);
            }
        }
    }

    public void print(int level, boolean lr) {
        System.out.print("level " + level + " from ");
        System.out.print(lr ? "left to right: " : "right to left: ");
    }
}
