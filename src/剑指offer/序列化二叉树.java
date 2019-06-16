package 剑指offer;

import java.util.Queue;
import java.util.LinkedList;

public class 序列化二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int x) {
            this.val = x;
        }
    }
    //递归实现序列号（前序遍历）
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        String res = root.val + ",";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }
    //递归实现反序列化
    public TreeNode Deserialize(String str) {
        String[] values = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < values.length; i++){
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    public TreeNode reconPreOrder(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
