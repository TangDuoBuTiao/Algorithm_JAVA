package 二叉树;
/*
判断一个二叉树是否是搜索二叉树
解法：中序遍历这颗树，如果是【**递增**】的，就是搜索二叉树
 */


import java.util.Stack;

public class 判断一个二叉树是否为搜索二叉树 {

    //递归方法实现
    Node last = null;   //定义一个全局变量，记录上一次遍历的节点

    public boolean isSearchBinaryTree_Recur(Node head) {
        if (head == null) {
            return true;
        }
        if (!isSearchBinaryTree_Recur(head.left)) {  //只要返回的是fasle, if语句成立，继续返回false
            return false;
        }
        if (last != null && head.value <= last.value) {
            return false;
        }
        last = head;  //更新last
        if (!isSearchBinaryTree_Recur(head.right)) {
            return false;
        }
        return true;

    }

    // 非递归（迭代）方式实现
    public boolean isSBT_UnRecur(Node head) {
        if (head != null) {
            Node last = null;   //记录上一次遍历的节点，方便与当前节点进行比较
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (last != null && head.value <= last.value) {
                        return false;
                    }
                    last = head;  // 更细last的值
                    head = head.right;
                }
            }
            return true;
        }
        return true;
    }
}
