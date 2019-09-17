package leetcode;


import com.sun.deploy.panel.TreeBuilder;

public class num543_二叉树的直径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = Math.max(res, high(root.left) + high(root.right));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return res;
    }

    public int high(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(high(root.left), high(root.right)) + 1;
    }
}
