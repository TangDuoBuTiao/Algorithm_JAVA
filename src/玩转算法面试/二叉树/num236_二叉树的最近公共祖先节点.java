package 玩转算法面试.二叉树;

public class num236_二叉树的最近公共祖先节点 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {  //z走到叶子节点
            return null;
        }
        if (root == p || root == q) {  //找到了其中一个节点，返回它
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);  //没找到，继续去左子树找，找到了就返回给left
        TreeNode right = lowestCommonAncestor(root.right, p, q); //左子树找完，再继续去右子树找
        if (left != null && right != null) {  //如果当前root的左右子树都返回的有值，则root就是最近的公共祖先
            return root;
        }
        if (left != null) {  //左不为空，右为空的情况，返回左孩子节点
            return left;
        }
        if (right != null) {
            return right;
        }
        //都不满足的话，说明以当前root为根的树，没有发现p和q,返回null
        return null;
    }
}
