package 玩转算法面试.二叉树;

public class num230_二叉搜索树第K小元素 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode knode = null;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        inorder(root, k);
        return knode.val;
    }

    int index = 0;
    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        index++;
        if (index == k) {
            knode = root;
        }
        inorder(root.right, k);
    }

}
