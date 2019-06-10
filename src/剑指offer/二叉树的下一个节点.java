package 剑指offer;
/*
 * 问题：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *      注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 解答：分三种情况：
 *      一、这个节点的右节点不为空：那么下一个节点是这个右节点一直找左子树，直到为空。
 *      二、这个节点的右节点为空，并且这个节点是其父节点的左子树：那么下一个节点是其父节点。
 *      三、这个节点的右节点为空，并且这个节点是其父节点的右子树：那么一直向上找父节点，直到某个节点是其父节点的左子树，
 *         返回其父节点。
 */

public class 二叉树的下一个节点 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        public TreeLinkNode(int x) {
            this.val = x;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.right != null) {
            TreeLinkNode cur = pHead.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        if (pHead.next != null && pHead.next.left == pHead) {
            return pHead.next;
        }
        while (pHead.next != null && pHead.next.right == pHead) {
            pHead = pHead.next;
        }
        return pHead.next;
    }
}

