package 玩转算法面试.栈和队列;


import sun.reflect.generics.tree.Tree;

import java.util.*;

public class num103_二叉树的锯齿形层次遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        boolean right2left = false;   //从右到左->尾出头进
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = right2left ? queue.pollLast() : queue.pollFirst();
                size--;
                list.add(cur.val);
                if (right2left) {  //尾出，头进
                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                } else {
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.addLast(cur.right);
                    }
                }
            }
            right2left = !right2left;
            res.add(list);
        }
        return res;
    }

}
