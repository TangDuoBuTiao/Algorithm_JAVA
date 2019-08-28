package 玩转算法面试.二叉树;

/*
 * 从根到叶子节点的最小深度
 */

public class num111_二叉树的最小深度 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }

        public int minDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null){
                return 1;
            }
            int res = Integer.MAX_VALUE;
            if(root.left != null){
                res = Math.min(res, minDepth(root.left));
            }
            if(root.right != null){
                res = Math.min(res, minDepth(root.right));
            }
            return res;
        }
    }
}
