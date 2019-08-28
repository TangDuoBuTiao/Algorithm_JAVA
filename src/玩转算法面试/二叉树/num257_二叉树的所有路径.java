package 玩转算法面试.二叉树;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class num257_二叉树的所有路径 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> bianryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> lefts = bianryTreePaths(root.left);
        for (int i = 0; i < lefts.size(); i++) {
            res.add(root.val + "->" + lefts.get(i));
        }

        List<String> rights = bianryTreePaths(root.right);
        for (int i = 0; i < rights.size(); i++) {
            res.add(root.val + "->" + rights.get(i));
        }

        return res;
    }
}
