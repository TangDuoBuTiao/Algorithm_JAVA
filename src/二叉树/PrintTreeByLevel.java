package 二叉树;
/*
以层序遍历的方式打印二叉树
 */

import java.util.LinkedList;
import java.util.Queue;


public class PrintTreeByLevel {

    //使用队列，做类似于BFS的遍历。用last和nLast两个变量分别记录当前行的最后一个节点和下一行的最后一个节点
    public void printTreeByLevel(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        int level = 1;
        System.out.print("level " + level + " : ");
        Node last = head;
        Node nLast = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");

            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {   //表明遍历到这一层的最后一个节点，
                last = nLast;                     //last更新为下一层的最后一个节点
                System.out.print("\nlevel " + (level + 1) + " : ");
            }
        }
    }
}
