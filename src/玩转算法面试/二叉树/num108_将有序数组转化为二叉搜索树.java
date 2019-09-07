package 玩转算法面试.二叉树;

import sun.reflect.generics.tree.Tree;

public class num108_将有序数组转化为二叉搜索树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {  //说明是叶子节点，直接返回这个节点
            return new TreeNode(nums[l]);
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, l, mid - 1);
        root.right = buildTree(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        num108_将有序数组转化为二叉搜索树 s = new num108_将有序数组转化为二叉搜索树();
        s.sortedArrayToBST(arr);
    }
}
