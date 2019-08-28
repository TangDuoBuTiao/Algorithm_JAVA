package 玩转算法面试.二叉树;

public class num100_相同的树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     *  如果p和q同时为null，返回true；
        接下来如果其中一个不为null，说明一个为null，一个不为null,返回false;
        接下来如果p和q的值不同，返回fasle;
        最后递归调用isSameTree,分别传入左子树和右子树；
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
