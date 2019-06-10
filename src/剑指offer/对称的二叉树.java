package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;


public class 对称的二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    /*
     * 递归实现
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }

    public boolean comRoot(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
    }

    /*
     * 非递归实现：使用宽度优先检索，用队列保存节点，成对入队，成对出队。
     */
    public boolean isSysmmetricalBFS(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()) {
            //成对取出
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {   //一个为空，另一个不为空，
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            //成对插入
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
