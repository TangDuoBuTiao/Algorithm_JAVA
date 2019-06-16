package 剑指offer;

import java.util.Stack;

public class 二叉搜索树的第K个节点 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode cur = pRoot;
        if (pRoot != null) {
            int count = 0;
            Stack<TreeNode> stack = new Stack<>();
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    count++;
                    if(count == k){
                        return cur;
                    }
                    cur = cur.right;
                }
            }
        }
        return cur;
    }
}
