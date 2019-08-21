package 二叉树;
/*
 * 根据前序和中序遍历构建二叉树
 */

public class 根据前序和中序遍历重建二叉树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    //用preStart,preEnd,inStart, inEnd保存序列开始和结束的位置
    public static TreeNode buildTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode res;
        res = new TreeNode(pre[preStart]);  //初始化根节点
        int index = 0;   //在中序遍历中找到当前根节点
        for (int i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                index = i;
                break;
            }
        }
        /*
         * 左子树的preStart: preStart + 1
         * 左子树的preEnd: preStart + 根据中序求出左子树元素个数; preStart + (index - inStart)
         * 左子树的inStart: inStart
         * 左子树的inEnd: index - 1
         * 右子树的preStart: 左子树的preEnd + 1就是右子树的preStart; preStart + (index - inStart) + 1
         * 右子树的preEnd: preEnd
         * 右子树的inStart: index + 1
         * 右子树的inEnd: inEnd
         */
        res.left = buildTree(pre, in, preStart + 1, preStart + index - inStart, inStart, index - 1);
        res.right = buildTree(pre, in, preStart + index - inStart + 1, preEnd, index + 1, inEnd);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {3, 2, 4, 1, 5, 6};
        reConstructBinaryTree(a, b);
    }


}
