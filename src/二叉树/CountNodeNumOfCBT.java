package 二叉树;
/*
问题：统计完全二叉树的节点个数
     遍历整棵树求解不是最优解，如果层数为h，优化后时间复杂度为O(h^2)
 */

import 二叉树.InitBinaryTree;


public class CountNodeNumOfCBT {

    //根据节点的左子树，找当前节点下面还有的层数，参数level是当前节点的层数
    public int mostLeftLevel(Node head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }

    //主函数
    public int countNodeNumOfCBT(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    //递归函数
    public int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {  //说明当前节点的左子树是满二叉树，
            return (1 << (h - 1)) + bs(node.right, level + 1, h);
        } else {                                //当前节点的右子树是满的
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    public static void main(String[] args) {


    }
}
