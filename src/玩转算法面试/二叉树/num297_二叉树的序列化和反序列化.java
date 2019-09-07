package 玩转算法面试.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class num297_二叉树的序列化和反序列化 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        preorder(root);
        return sb.toString();
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        sb.append(root.val + "!");
        preorder(root.left);
        preorder(root.right);
    }

    //反序列化二叉树
    // eg： 1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String str[] = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            queue.offer(str[i]);
        }
        return buildTree(queue);

    }

    public TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = buildTree(queue);
        head.right = buildTree(queue);
        return head;
    }
}
