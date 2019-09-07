package 剑指offer;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<String> list = printPath(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String path = list.get(i);
            String[] s = path.split("#");
            int tmp = 0;
            ArrayList<Integer> l = new ArrayList<>();
            for (int j = 0; j < s.length; j++) {
                l.add(Integer.valueOf(s[j]));
                tmp += Integer.valueOf(s[j]);
            }
            if (tmp == target) {
                res.add(l);
            }
        }
        return res;
    }

    public ArrayList<String> printPath(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        ArrayList<String> lefts = printPath(root.left);
        for (int i = 0; i < lefts.size(); i++) {
            res.add(root.val + "#" + lefts.get(i));
        }
        ArrayList<String> rights = printPath(root.right);
        for (int i = 0; i < rights.size(); i++) {
            res.add(root.val + "#" + rights.get(i));
        }
        return res;
    }
}
