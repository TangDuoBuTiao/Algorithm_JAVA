package 二叉树;
/*
通过前序遍历序列化和反序列化二叉树，null用“#”代替，节点之间用“！”隔开
 */

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderSerialBinaryTree {

    // 前序遍历序列化二叉树为字符串
    public String serialBypre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialBypre(head.left);
        res += serialBypre(head.right);
        return res;
    }

    //通过前序遍历的结果字符串str反序列化二叉树，即重建二叉树
    public Node reconByPreString(String prestr) {
        //先把字符串转换为字符串数组
        String[] values = prestr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; 1 != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    public static void main(String[] args){
        String str = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";
        PreOrderSerialBinaryTree f = new PreOrderSerialBinaryTree();
        f.reconByPreString(str);
    }

}
