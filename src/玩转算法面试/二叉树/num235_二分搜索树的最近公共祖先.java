package 玩转算法面试.二叉树;

public class num235_二分搜索树的最近公共祖先 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {  //说明p和q都在root的左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {  //说明p和q都在root的右子树
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;   //pq在root两侧，或者p或者q就是root
    }
}
