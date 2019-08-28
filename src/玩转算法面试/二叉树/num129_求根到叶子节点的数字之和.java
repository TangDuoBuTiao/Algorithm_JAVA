package 玩转算法面试.二叉树;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class num129_求根到叶子节点的数字之和 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        List<String> res = treePaths(root);
        int ans = 0;
        for (int i = 0; i < res.size(); i++) {
            ans += Integer.valueOf(res.get(i));
        }
        return ans;
    }

    public List<String> treePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> lefts = treePaths(root.left);
        for (int i = 0; i < lefts.size(); i++) {
            res.add(root.val + lefts.get(i));
        }

        List<String> rights = treePaths(root.right);
        for (int i = 0; i < rights.size(); i++) {
            res.add(root.val + rights.get(i));
        }
        return res;
    }

}
