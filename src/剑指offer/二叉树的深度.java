package 剑指offer;

public class 二叉树的深度 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }
}
