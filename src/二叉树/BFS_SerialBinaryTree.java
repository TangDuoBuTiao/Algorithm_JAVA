package 二叉树;
/*
层次遍历（宽度优先检索）序列化和反序列化二叉树，null用“#”代替，节点之间用“！”隔开
 */

import java.util.LinkedList;
import java.util.Queue;

public class BFS_SerialBinaryTree {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //序列化二叉树为字符串,使用队列，
    public String serialByBFS(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);    //先把头结点加入队列
        String res = head.value + "!";    //头节点值加进res
        while (!queue.isEmpty()) {     //队列不为空，就一直循环（先出队，再看出队元素的左子树是否为空）
            head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);   //如果左子树不空，就进队，并把左子树的值加进res
                res += head.left.value + "!";
            } else {                    //如果为空，就把“#”加进res
                res += "#!";
            }
            if (head.right != null) {  //右子树同左子树
                queue.offer(head.right);
                res += head.right.value + "!";
            } else {
                res += "#!";
            }
        }
        return res;
    }

    //反序列化字符串str为二叉树
    public Node reconByBFSString(String str) {
        String[] values = str.split("!");
        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        Node head = generateNodeByString(values[index++]);
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    //字符转化为节点
    public Node generateNodeByString(String s) {
        if (s == null) {
            return null;
        }
        return new Node(Integer.valueOf(s));
    }
}
