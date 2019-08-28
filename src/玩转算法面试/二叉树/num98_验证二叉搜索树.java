package 玩转算法面试.二叉树;


import java.util.ArrayList;
import java.util.List;

public class num98_验证二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //方法一：判断中序遍历结果是不是升序
    public boolean isValidBST1(TreeNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> res = new ArrayList<>();
        inorder(head, res);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


    //方法2
    public boolean isValidBST2(TreeNode head) {
        if (head == null) {
            return true;
        }
        if (head.left != null && head.val <= head.left.val) {
            return false;
        }
        if (head.right != null && head.val >= head.right.val) {
            return false;
        }

        return isValidBST2(head.left) && isValidBST2(head.right);
    }


}
