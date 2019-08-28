package 玩转算法面试.二叉树;
/*
 * 从根到叶子节点的路径和为给定值
 */

public class num112_路径总和 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {  //说明这条路径没有找到
            return false;
        }
        if (root.left == null && root.right == null) {  //为叶子节点
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}
