package 玩转算法面试.二叉树;

public class num437_路径总和3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //在以root为根节点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = findPath(root, sum);  //包含当前root时的路径
        res += pathSum(root.left, sum);  //不包含当前root时，在左孩子找路径其和为sum
        res += pathSum(root.right, sum);  //不包含当前root时，

        return res;
    }

    //在以node为根节点的二叉树中，寻找包含node的路径，和为sum
    public int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == sum) {  //为什么找到了，没有直接返回1，是因为后续可能有负值，还有可能和为sum
            res++;
        }

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;
    }

}
