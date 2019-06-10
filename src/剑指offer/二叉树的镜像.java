package 剑指offer;
/*
 * step1: 先序遍历二叉树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。
 * step2: 递归遍历每个节点的子节点，同样，如果遍历到的子节点有子节点，就交换它的两个子节点。
 * 当交换完所有非叶子节点的子节点后，就完成了镜像
 */

public class 二叉树的镜像 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
