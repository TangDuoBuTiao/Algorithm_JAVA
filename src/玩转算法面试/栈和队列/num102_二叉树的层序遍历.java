package 玩转算法面试.栈和队列;

import com.sun.deploy.panel.ITreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num102_二叉树的层序遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                while(size > 0){
                    TreeNode cur = queue.poll();
                    list.add(cur.val);
                    size--;
                    if(cur.left != null){
                        queue.add(cur.left);
                    }
                    if(cur.right != null){
                        queue.add(cur.right);
                    }
                }
                res.add(list);
            }
            return res;
        }
    }
}
