package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 把二叉树打印成多行 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        TreeNode last = pRoot;
        TreeNode nLast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            pRoot = queue.poll();
            if (pRoot.left != null) {
                nLast = pRoot.left;
                queue.offer(pRoot.left);
            }
            if (pRoot.right != null) {
                nLast = pRoot.right;
                queue.offer(pRoot.right);
            }
            list.add(pRoot.val);
            if (pRoot == last && !queue.isEmpty()) {
                last = nLast;
                nLast = null;
                res.add(new ArrayList(list));
                list.clear();
            }
        }
        res.add(new ArrayList(list));
        return res;
    }
}
