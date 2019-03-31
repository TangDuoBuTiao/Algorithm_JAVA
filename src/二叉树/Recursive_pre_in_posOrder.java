package 二叉树;
/*
利用递归的方式实现二叉树的前序、中序和后序遍历
 */

public class Recursive_pre_in_posOrder {
    //二叉树的数据结构
    public class Node {
        public int value;
        public Node left;  //左子树
        public Node right; //右子树

        public Node(int data) {
            this.value = data;
        }
    }

    //前序遍历：根，左，右
    public void perOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        perOrderRecur(head.left);
        perOrderRecur(head.right);
    }

    //中序遍历：左，根，右
    public void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    //后序遍历：左，右，根
    public void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }
}
