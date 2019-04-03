package 二叉树;
/*
判断一棵二叉树是否为完全二叉树，以层序遍历二叉树，从左到右
判断条件：1.如果一个节点没有左子树，但是有右子树，返回false
         2.如果一个节点只有左子树，那么这个左子树必为叶子节点，否则返回false
         3.遍历过程中不返回false，就返回true
 */

import java.util.Queue;
import java.util.LinkedList;


public class IsCompleteBinaryTree {

    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node l = null;
        Node r = null;
        boolean leaf = false;

        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;

            // leaf = true 表明前面有节点没有右子树，当后面再出现叶子，就不是完全二叉树
            if (leaf && (l != null || r != null) || (l == null && r != null)) {
                return false;
            }
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }else{          //当前节点没有右子树
                leaf = true;
            }

        }
        return true;
    }

}
