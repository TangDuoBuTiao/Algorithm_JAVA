package 二叉树;
/*
新的二叉树结构，新增一个parent指针，指向当前节点的父节点
问题：只给出一个二叉树中的某个节点node，找出这个节点node的后继节点。（在二叉树的中序遍历中）
 */

import java.util.Stack;

public class 在二叉树中找到一个节点的后继节点 {
    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    // 方法一：先根据父节点，一直往上找到根节点，再中序遍历，找到这个节点的下一个节点就是所求的后继节点
    public Node getNextNode1(Node node) {
        Node cur = node;
        while (cur.parent != null) {
            cur = cur.parent;
        }
        Node head = cur;
        //找到根节点后，进行中序遍历(思想：一直找左，左为空就弹出，再找右)
        Stack<Node> stack = new Stack<>();
        boolean flag = false;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (flag) {
                    return head;
                }
                if (head == node) {
                    flag = true;
                }
                head = head.right;
            }
        }
        return null;
    }

    /*
    方法二：不必遍历所有节点，分三种情况
    情况1：如果node有右子树，后继节点就是右子树上最左边的节点
    情况2：如果node没有右子树，那么先看node是不是node父节点的左孩子节点，如果是，那么node的父节点就是就是其后继；
          如果是右孩子节点，就向上寻找node的后继，假设向上移动到的节点记为s, s的父节点记为p,如果s是p的左孩子节点，
          那么p就是node的后继，否则就一直向上移动
    情况3：如果情况2一直向上找，都移动到空节点时，还没发现node的后继，说明node不存在后继节点。
     */

    public Node getNextNode2(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getMostLeft(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {  //如果node是其父节点的左子树，不进while,直接返回parent即可
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public Node getMostLeft(Node node) {  //找到这个node节点最左边的节点，如果这个节点没有左子树，就返回其本身。
        if (node == null) {
            return node;
        }
        while (node != null) {
            node = node.left;
        }
        return node;
    }
}
